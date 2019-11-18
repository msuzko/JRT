package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    private static int priority = MIN_PRIORITY - 1;

    public static int getMyPriority() {
        if (priority == MAX_PRIORITY ||
                (Thread.currentThread().getThreadGroup() != null
                        && priority == Thread.currentThread().getThreadGroup().getMaxPriority())) {
            priority = MIN_PRIORITY;
            return priority;
        } else
            return ++priority;
    }

    public MyThread() {
        setPriority(getMyPriority());
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(getMyPriority());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority(getMyPriority());
    }

    public MyThread(String name) {
        super(name);
        setPriority(getMyPriority());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority(getMyPriority());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(getMyPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority(getMyPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority(getMyPriority());
    }

}
