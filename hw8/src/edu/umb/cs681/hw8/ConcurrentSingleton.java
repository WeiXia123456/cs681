package edu.umb.cs681.hw8;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton implements Runnable{

    private ConcurrentSingleton(){};
    private static ConcurrentSingleton instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    public static ConcurrentSingleton getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new ConcurrentSingleton();
            }
            return instance;
        } finally {
            lock.unlock();
        }

    }

    public void run() {
        System.out.println("Current Thread is " + Thread.currentThread().getId() +
                ", instance is " + instance);
    }

}
