package com.javarush.task.task23.task2304;

import java.util.HashMap;
import java.util.Map;

public class MockView {
    private static final Map FAKE_TASK_CRITERIA = new HashMap();
    private static final Map FAKE_NAME_CRITERIA = new HashMap();

<<<<<<< HEAD
    public static Map getFakeTaskCriteria() {
        return FAKE_TASK_CRITERIA;
    }

    public static Map getFakeNameCriteria() {
=======
    public static Map getFakeTasksCriteria() {
        return FAKE_TASK_CRITERIA;
    }

    public static Map getFakeNamesCriteria() {
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        return FAKE_NAME_CRITERIA;
    }
}
