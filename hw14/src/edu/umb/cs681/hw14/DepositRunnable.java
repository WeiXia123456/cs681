package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;

public class DepositRunnable implements Runnable{

    private volatile boolean done;
    private ThreadSafeBankAccount2 account;

    public DepositRunnable(ThreadSafeBankAccount2 account) {
        this.account = account;
    }

    public void setDone() {

            done = true;

    }
    @Override
    public void run() {
        while(true) {
            if(done) {
                System.out.println("stop current deposit thread" + Thread.currentThread().getName());
                break;
            }
            account.deposit(300);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                continue;
            }

        }

    }
}
