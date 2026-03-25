package com.sabeshkin.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSyncVolatileExample {
    private static volatile int counter = 0;

    public static void main(String[] args) {
        final Object lock = new Object();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized(lock){
                    counter++;
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter);
    }
}

