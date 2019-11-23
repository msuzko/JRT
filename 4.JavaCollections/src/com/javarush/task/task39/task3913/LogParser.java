package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private List<LogNode> logs = new ArrayList<>();

    public LogParser(Path logDir) {
        try {
            parsePath(logDir);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void parsePath(Path logDir) throws IOException, ParseException {
        List<Path> files = Files.list(logDir)
                .filter(f -> f.toString().endsWith(".log")).collect(Collectors.toList());
        for (Path file : files)
            try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
                while (reader.ready()) {
                    LogNode newNode = new LogNode(reader.readLine());
                    logs.add(newNode);
                }
            }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .map(LogNode::getIp)
                .collect(Collectors.toSet());
    }


    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.name.equals(user))
                .map(LogNode::getIp)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.event == event)
                .map(LogNode::getIp)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.status == status)
                .map(LogNode::getIp)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllUsers() {
        return logs.stream()
                .map(LogNode::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .map(LogNode::getName)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.getName().equals(user))
                .map(LogNode::getEvent)
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.getIp().equals(ip))
                .map(LogNode::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUsersByEvent(after, before, Event.LOGIN);
    }

    private Set<String> getUsersByEvent(Date after, Date before, Event login) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.getEvent() == login)
                .map(LogNode::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUsersByEvent(after, before, Event.DOWNLOAD_PLUGIN);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUsersByEvent(after, before, Event.WRITE_MESSAGE);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getUsersByEvent(after, before, Event.SOLVE_TASK);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getLogNodeStreamByTAskAndEvent(after, before, task, Event.SOLVE_TASK)
                .map(LogNode::getName)
                .collect(Collectors.toSet());
    }

    private Stream<LogNode> getLogNodeStreamByTAskAndEvent(Date after, Date before, int task, Event solveTask) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.getEvent() == solveTask
                        && log.task.equals(task));
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getUsersByEvent(after, before, Event.DONE_TASK);
    }


    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getLogNodeStreamByTAskAndEvent(after, before, task, Event.DONE_TASK)
                .map(LogNode::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getDateStreamByEvent(user, after, before, event)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getDatesByStatus(after, before, Status.FAILED);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getDatesByStatus(after, before, Status.ERROR);
    }

    private Set<Date> getDatesByStatus(Date after, Date before, Status status) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.getStatus() == status)
                .map(log -> new Date(log.date))
                .collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return getDateStreamByEvent(user, after, before, Event.LOGIN)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return getDateWhenUserFirstEventForTask(user, after, before, task, Event.SOLVE_TASK);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return getDateWhenUserFirstEventForTask(user, after, before, task, Event.DONE_TASK);
    }

    private Date getDateWhenUserFirstEventForTask(String user, Date after, Date before, int task, Event event) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.event == event
                        && log.task.equals(task)
                        && log.getName().equals(user))
                .map(log -> new Date(log.date))
                .sorted()
                .findFirst()
                .orElse(null);
    }


    private Stream<Date> getDateStreamByEvent(String user, Date after, Date before, Event event) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.getEvent() == event
                        && log.getName().equals(user))
                .map(log -> new Date(log.date));
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getDateStreamByEvent(user, after, before, Event.WRITE_MESSAGE)
                .collect(Collectors.toSet());
    }


    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getDateStreamByEvent(user, after, before, Event.DOWNLOAD_PLUGIN)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .map(LogNode::getEvent)
                .collect(Collectors.toSet());
    }

    private Set<Status> getAllStatuses(Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .map(LogNode::getStatus)
                .collect(Collectors.toSet());
    }


    private Set<Date> getAllDates() {
        return logs.stream()
                .map(log -> new Date(log.date))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.getIp().equals(ip))
                .map(LogNode::getEvent)
                .collect(Collectors.toSet());
    }


    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.name.equals(user))
                .map(LogNode::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getEventsByStatus(after, before, Status.FAILED);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getEventsByStatus(after, before, Status.ERROR);
    }

    private Set<Event> getEventsByStatus(Date after, Date before, Status status) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.getStatus() == status)
                .map(LogNode::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return getNumberTasksWithEvent(task, after, before, Event.SOLVE_TASK);
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return getNumberTasksWithEvent(task, after, before, Event.DONE_TASK);
    }

    private int getNumberTasksWithEvent(int task, Date after, Date before, Event event) {
        return (int) getLogsBetweenDates(after, before)
                .filter(log -> log.getEvent() == event
                        && log.task == task)
                .count();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return getAllTasksAndTheirNumberByEvent(after, before, Event.SOLVE_TASK);
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return getAllTasksAndTheirNumberByEvent(after, before, Event.DONE_TASK);
    }

    private Map<Integer, Integer> getAllTasksAndTheirNumberByEvent(Date after, Date before, Event event) {
        return getLogsBetweenDates(after, before)
                .filter(log -> log.getEvent() == event)
                .collect(Collectors.toMap(LogNode::getTask, log -> 1, Integer::sum));
    }

    public Set simpleExecute(String query) {
        switch (query.trim()) {
            case "get ip":
                return getUniqueIPs(null, null);
            case "get user":
                return getAllUsers();
            case "get event":
                return getAllEvents(null, null);
            case "get status":
                return getAllStatuses(null, null);
            case "get date":
                return getAllDates();
            default:
                return null;
        }
    }

    @Override
    public Set execute(String query) {
        if (query.split(" ").length == 2)
            return simpleExecute(query);
        String pattern = "get (?<tag>\\w+)(\\sfor\\s(?<field>\\w+)\\s=\\s\"(?<value>.+?)\")?(\\sand date between" +
                "\\s\"(?<after>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\"\\sand\\s\"" +
                "(?<before>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\")?";
        Matcher matcher = Pattern.compile(pattern).matcher(query);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        if (matcher.find()) {
            String tag = matcher.group("tag");
            String field = matcher.group("field");
            String value = matcher.group("value");
            Date after = null;
            Date before = null;
            try {
                if (matcher.group("after") != null && matcher.group("before") != null) {
                    after = format.parse(matcher.group("after"));
                    before = format.parse(matcher.group("before"));
                }
                if (field.equals("date"))
                    value = format.parse(value).toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String finalValue = value;
            Date finalAfter = after;
            Date finalBefore = before;
            return logs.stream()
                    .filter(log -> log.get(field).toString().equalsIgnoreCase(finalValue)
                            && log.date > (finalAfter == null ? 0 : finalAfter.getTime())
                            && log.date < (finalBefore == null ? Long.MAX_VALUE : finalBefore.getTime()))
                    .map(log -> log.get(tag))
                    .collect(Collectors.toSet());
        }
        return null;

    }

    private Stream<LogNode> getLogsBetweenDates(Date after, Date before) {
        return logs.stream().filter(
                log -> log.date >= getAfterNotNull(after)
                        && log.date <= getBeforeNotNull(before));
    }

    private long getAfterNotNull(Date after) {
        return after == null ? 0 : after.getTime();
    }

    private long getBeforeNotNull(Date before) {
        return before == null ? Long.MAX_VALUE : before.getTime();
    }

    private static class LogNode {
        private String ip;
        private String name;
        private Long date;
        private Event event;
        private Integer task;
        private Status status;

        private LogNode(String log) throws ParseException {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            String[] fields = log.split("\t");
            this.ip = fields[0];
            this.name = fields[1];
            this.date = format.parse(fields[2]).getTime();
            String[] eventAndTask = fields[3].split(" ");
            this.event = Event.valueOf(eventAndTask[0]);
            Integer task = -1;
            if (eventAndTask.length == 2)
                task = Integer.parseInt(eventAndTask[1]);
            this.task = task;
            this.status = Status.valueOf(fields[4]);
        }

        public Object get(String fieldName) {
            switch (fieldName.toLowerCase()) {
                case "ip":
                    return ip;
                case "user":
                    return name;
                case "date":
                    return new Date(date);
                case "status":
                    return status;
                case "event":
                    return event;
                case "task":
                    return task;
                default:
                    return null;
            }
        }

        String getIp() {
            return ip;
        }

        String getName() {
            return name;
        }

        Event getEvent() {
            return event;
        }

        Integer getTask() {
            return task;
        }

        Status getStatus() {
            return status;
        }
    }
}