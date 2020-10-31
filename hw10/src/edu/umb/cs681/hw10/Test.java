package edu.umb.cs681.hw10;

public class Test {
    public static void main(String[] args) {
        RunnableCancellableInterruptiblePrimeFactorizer r1 =
                new RunnableCancellableInterruptiblePrimeFactorizer(122, 2, 122);
        Thread t1 = new Thread(r1);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r1.setDone();
        t1.interrupt();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n" + r1.getPrimeFactors() + " are the prime factors.");
    }
}
