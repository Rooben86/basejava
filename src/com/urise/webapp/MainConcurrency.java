package com.urise.webapp;

import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {
    public static final int THREADS_NUMBER = 10000;
    private volatile int counter;
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getState());

        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
//                throw new IllegalStateException();
            }
        };
        thread0.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getState());
        }).start();

        System.out.println(thread0.getName() + ", " + thread0.getState());

        final MainConcurrency mainConcurrency = new MainConcurrency();
        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);

        for (int i = 0; i < THREADS_NUMBER; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
            });
            thread.start();
            threads.add(thread);
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(mainConcurrency.counter);

        final String lock1 = "CarKey";
        final String lock2 = "HomeKey";
        deadlock(lock1, lock2);
        deadlock(lock2, lock1);
    }

    private static void deadlock(String C, String H) {
        new Thread(() -> {
            System.out.println("parking the car / leaving the apartment -" + C);
            synchronized (C) {
                System.out.println("I hold the " + C + " and now I need the second key, which is " + H);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (H) {
                    System.out.println("I got the second key, which is the " + H);
                }
            }
        }).start();
    }

    private void inc() {
        counter++;
    }
}
