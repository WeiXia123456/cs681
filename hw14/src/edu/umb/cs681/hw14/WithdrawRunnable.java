package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;

public class WithdrawRunnable implements Runnable{

    private ThreadSafeBankAccount2 account;
    private volatile boolean done;

    public WithdrawRunnable(ThreadSafeBankAccount2 account){
        this.account = account;
    }

    public void setDone() {
        done = true;
    }

    @Override
    public void run() {

        while (true) {
            if (done) {
                System.out.println("stop the current withdraw thread " + Thread.currentThread().getName());
                break;
            }

            account.withdraw(100);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                continue;
            }
        }
    }
}
