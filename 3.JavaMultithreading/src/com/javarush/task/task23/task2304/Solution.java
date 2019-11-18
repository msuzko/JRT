package com.javarush.task.task23.task2304;

import java.util.List;
import java.util.Map;

/*
Inner 3
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
<<<<<<< HEAD
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
=======
        Map taskCriteria = MockView.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNamesCriteria();
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    public static void main(String[] args) {

    }

<<<<<<< HEAD
    private class TaskDataProvider implements DbDataProvider<Task> {
=======
    private class TaskDataProvider implements DbDataProvider{
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

        @Override
        public void refreshAllData(Map criteria) {
            tasks = MockDB.getFakeTasks(criteria);
        }
    }
<<<<<<< HEAD

    private class NameDataProvider implements DbDataProvider<String> {
        @Override
        public void refreshAllData(Map criteria) {
            names = MockDB.getFakeNames(criteria);

        }
    }
=======
    private class NameDataProvider implements DbDataProvider{

        @Override
        public void refreshAllData(Map criteria) {
           names = MockDB.getFakeNames(criteria);
        }
    }


>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
}
