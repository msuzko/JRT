package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread target) {
        thread = target;
    }

    @Override
    public void run() {
        super.run();
        State state = thread.getState();
        State newState;
        while (state != State.TERMINATED) {
            newState = thread.getState();
            if (state != newState) {
                System.out.println(state);
                state = newState;
            }
        }
        System.out.println(state);
    }
}
