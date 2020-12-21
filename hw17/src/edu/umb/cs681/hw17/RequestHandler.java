package edu.umb.cs681.hw17;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable{
    private boolean done;
    private ReentrantLock lock = new ReentrantLock();
    public void setDone() {
        lock.lock();

        try {
            done = true;
        } finally {
            lock.unlock();
        }
    }
    @Override
    public void run() {
        Map<Integer, Path> map1 = new HashMap<>();
        map1.put(0, Paths.get("a.html"));
        map1.put(1, Paths.get("b.html"));
        map1.put(2, Paths.get("c.html"));
        map1.put(3, Paths.get("d.html"));
        map1.put(4, Paths.get("abc.txt"));
        while (true) {
            lock.lock();
            try {
                if (done == true) {
                    System.out.println("stop the current thread " + Thread.currentThread().getName());
                    break;
                }
            } finally {
                lock.unlock();
            }
            Random random = new Random();
            int number = random.nextInt(5);
            Path randomFile = map1.get(number);
            AccessCounter.getInstance().increment(randomFile);
            AccessCounter.getInstance().getCount(randomFile);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                continue;
            }

        }

    }
}
