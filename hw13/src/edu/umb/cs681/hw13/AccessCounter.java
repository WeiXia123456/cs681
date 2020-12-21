package edu.umb.cs681.hw13;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
    private Map<Path, Integer> map = new HashMap<>();
    private ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private static AccessCounter counter;

    public AccessCounter() {

    }

    public static AccessCounter getInstance() {
        lock2.lock();
        try {
            if (counter == null) {
                counter =  new AccessCounter();
            }
            return counter;
        }finally {
            lock2.unlock();
        }

    }

    public void increment(Path path) {
        lock1.lock();
        try{
            Integer num = map.get(path);
            if (num != null) {
                map.put(path, num + 1);
            } else {
                map.put(path, 1);
            }
        } finally {
            lock1.unlock();
        }
    }

    public int getCount(Path path) {
        lock1.lock();
        try{
            Integer num = map.get(path);
            if (num != null) {
                return num;
            } else {
                return 0;
            }
        } finally {
            lock1.unlock();
        }
    }


    public Map<Path, Integer> getMap() {
        return map;
    }


}
