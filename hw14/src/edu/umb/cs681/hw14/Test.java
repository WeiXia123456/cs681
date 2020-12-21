package edu.umb.cs681.hw14;

public class Test {

    public static void main(String[] args) {
        ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();
        WithdrawRunnable w1 = new WithdrawRunnable(account);
        WithdrawRunnable w2 = new WithdrawRunnable(account);
        WithdrawRunnable w3 = new WithdrawRunnable(account);
        DepositRunnable d1 = new DepositRunnable(account);
        DepositRunnable d2 = new DepositRunnable(account);
        DepositRunnable d3 = new DepositRunnable(account);

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w3);
        Thread t4 = new Thread(d1);
        Thread t5 = new Thread(d2);
        Thread t6 = new Thread(d3);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w1.setDone();
        w2.setDone();
        w3.setDone();
        d1.setDone();
        d2.setDone();
        d3.setDone();

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();
        t5.interrupt();
        t6.interrupt();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }
}
