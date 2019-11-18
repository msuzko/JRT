package com.javarush.task.task23.task2304;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MockDB {
    private static final List<Solution.Task> FAKE_TASKS = new ArrayList<>();
    private static final List<String> FAKE_NAMES = new ArrayList<>();

    public static List<Solution.Task> getFakeTasks(Map criteria) {
<<<<<<< HEAD
        return MockView.getFakeTaskCriteria().equals(criteria) ? FAKE_TASKS : null;
    }

    public static List<String> getFakeNames(Map criteria) {
        return MockView.getFakeNameCriteria().equals(criteria) ? FAKE_NAMES : null;
=======
        return MockView.getFakeTasksCriteria().equals(criteria) ? FAKE_TASKS : null;
    }

    public static List<String> getFakeNames(Map criteria) {
        return MockView.getFakeNamesCriteria().equals(criteria) ? FAKE_NAMES : null;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}
