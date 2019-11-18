package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
//    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null)
            synchronized (StatisticManager.class) {
                if (instance == null)
                    instance = new StatisticManager();
            }
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

//    public void register(Cook cook) {
//        cooks.add(cook);
//    }

//    public Set<Cook> getCooks() {
//        return cooks;
//    }

    public Map<Date, Double> getProfit() {
        Map<Date, Double> profits = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow event : statisticStorage.get(EventType.SELECTED_VIDEOS)) {
            Date date = dateWithoutTime(event.getDate());
            VideoSelectedEventDataRow eventData = (VideoSelectedEventDataRow) event;
            if (profits.containsKey(date)) {
                profits.put(date, profits.get(date) + (0.01d * (double) eventData.getAmount()));
            } else {
                profits.put(date, (0.01d * (double) eventData.getAmount()));
            }
        }
        return profits;
    }

    public Map<Date, Map<String, Integer>> getCookTime() {
        List<EventDataRow> eventDataRows = statisticStorage.get(EventType.COOKED_ORDER);
        Map<Date, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());
        Date date;
        Calendar calendar;
        for (EventDataRow eventDataRow : eventDataRows) {
            CookedOrderEventDataRow cookedOrder = (CookedOrderEventDataRow) eventDataRow;
            calendar = Calendar.getInstance();
            calendar.setTime(cookedOrder.getDate());
            GregorianCalendar gc = new GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            date = gc.getTime();
            if (result.containsKey(date)) {
                Map<String, Integer> cook = result.get(date);
                int value;
                if (cook.containsKey(cookedOrder.getCookName())) {
                    value = cook.get(cookedOrder.getCookName());
                    value += Math.toIntExact(Math.round(cookedOrder.getTime() / 60.0));
                } else {
                    value = Math.toIntExact(Math.round(cookedOrder.getTime() / 60.0));
                }
                cook.put(cookedOrder.getCookName(), value);
            } else {
                Map<String, Integer> cook = new TreeMap<>();
                cook.put(cookedOrder.getCookName(), Math.toIntExact(Math.round(cookedOrder.getTime() / 60.0)));
                result.put(date, cook);
            }
        }
        return result;

    }

    private Date dateWithoutTime(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            for (EventType event : EventType.values())
                storage.put(event, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType eventType) {
            return storage.get(eventType);
        }
    }
}
