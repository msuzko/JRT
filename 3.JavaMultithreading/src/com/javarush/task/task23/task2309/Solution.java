package com.javarush.task.task23.task2309;

<<<<<<< HEAD
import com.javarush.task.task23.task2309.vo.*;

import java.util.ArrayList;
=======

import com.javarush.task.task23.task2309.vo.*;

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
<<<<<<< HEAD
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }

    public List<User> getUsers(){
        return new AbstractDbSelectExecutor<User>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        }.execute();
    }
    public List<Location> getLocations(){
        return new AbstractDbSelectExecutor<Location>(){
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        }.execute();
    }
    public List<Server> getServers(){
        return new AbstractDbSelectExecutor<Server>(){
            @Override
            public String getQuery() {
                return null;
            }
        }.execute();
    }
    public List<Subscription> getSubscriptions(){
        return new AbstractDbSelectExecutor<Subscription>(){
            @Override
            public String getQuery() {
                return null;
            }
        }.execute();
    }
    public List<Subject> getSubjects(){
        return new AbstractDbSelectExecutor<Subject>(){
            @Override
            public String getQuery() {
                return null;
=======
        print(solution.getServers());
        print(solution.getSubjects());
        print(solution.getSubscriptions());
    }

    public List<Location> getLocations() {
        return new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                try {
                    return "SELECT * FROM " + getNewInstanceOfGenericType()
                            .getClass().getSimpleName().toUpperCase();
                } catch (InstantiationException | IllegalAccessException e) {
                    return "";
                }
            }
        }.execute();
    }

    public List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                try {
                    return "SELECT * FROM " + getNewInstanceOfGenericType()
                            .getClass().getSimpleName().toUpperCase();
                } catch (InstantiationException | IllegalAccessException e) {
                    return "";
                }
            }
        }.execute();
    }

    public List<Server> getServers() {
        return new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                try {
                    return "SELECT * FROM " + getNewInstanceOfGenericType()
                            .getClass().getSimpleName().toUpperCase();
                } catch (InstantiationException | IllegalAccessException e) {
                    return "";
                }
            }
        }.execute();
    }

    public List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                try {
                    return "SELECT * FROM " + getNewInstanceOfGenericType()
                            .getClass().getSimpleName().toUpperCase();
                } catch (InstantiationException | IllegalAccessException e) {
                    return "";
                }
            }
        }.execute();
    }

    public List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                try {
                    return "SELECT * FROM " + getNewInstanceOfGenericType()
                            .getClass().getSimpleName().toUpperCase();
                } catch (InstantiationException | IllegalAccessException e) {
                    return "";
                }
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
            }
        }.execute();
    }

<<<<<<< HEAD

=======
    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
}
