package edu.umb.cs681.hw15;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AdmissionControl {
    private int currentVisitors;
    private ReentrantLock lock = new ReentrantLock();
    private Condition enoughtVisitorsCondition = lock.newCondition();
    private Condition sufficientVisitorCondition = lock.newCondition();


    public void enter() {
        lock.lock();
        try {
            while(currentVisitors >= 5) {
                try {
                    System.out.println("Too many visitors. Please wait for a while!");
                    enoughtVisitorsCondition.await();
                } catch (InterruptedException e) {
                    break;
                }
            }
            currentVisitors++;
            sufficientVisitorCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void exit() {
        lock.lock();
        try {
            while (currentVisitors <= 0) {
                try {
                    System.out.println("No visitor exist");
                    sufficientVisitorCondition.await();
                } catch (InterruptedException e) {
                   break;
                }
            }
                currentVisitors--;
                enoughtVisitorsCondition.signalAll();

        } finally {
            lock.unlock();
        }
}


    public int countCurrentVisitors(){
        lock.lock();
        try {
            return currentVisitors;
        } finally {
            lock.unlock();
        }
    }


}
