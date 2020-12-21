package edu.umb.cs681.hw17;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
    private Map<Path, AtomicInteger> map = new ConcurrentHashMap<>();

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
        
        map.putIfAbsent(path, new AtomicInteger(0));
        map.get(path).incrementAndGet();
    }

    public int getCount(Path path) {
       AtomicInteger count = map.compute(path,(Path p, AtomicInteger value) -> {
            return value == null ? new AtomicInteger(0) : value;
        });
       return count.get();

    }


    public Map<Path, AtomicInteger> getMap() {
        return map;
    }


}
