package edu.umb.cs681.hw10;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer{
    private boolean done;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }

    public void setDone() {
        lock.lock();
        try {
            done = true;
        }
        finally {
            lock.unlock();
        }
    }

    public void generatePrimeFactors() {
        long divisor = from;
        long copy = dividend;
        while( dividend != 1 && divisor <= to ){
            lock.lock();
            try {
                if (done) {
                    System.out.print("Stopped generatePrimeFactors ");
                    break;
                }
                if (divisor > 2 && isEven(divisor)) {
                    divisor++;
                    continue;
                }
                if (dividend % divisor == 0) {
                    factors.add(divisor);
                    dividend /= divisor;
                } else {
                    if (divisor == 2) {
                        divisor++;
                    } else {
                        divisor += 2;
                    }
                }
            } finally {
                lock.unlock();
            }
        }
//        long multiplication = factors.stream().reduce((long)1,(result, p)-> result * p);
//        if (multiplication != copy && multiplication != 1) {
//            factors.add(copy / multiplication);
//        }
    }

    public static void main(String[] args) {
        System.out.println("prime factors of 115 ");
        RunnableCancellablePrimeFactorizer r1 = new RunnableCancellablePrimeFactorizer(115, 2, 115);
        Thread t1 = new Thread(r1);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

    //    r1.getPrimeFactors().forEach(p -> System.out.print(p + ", "));

        System.out.println();
        System.out.println("two thread produced prime factors of 204");
        RunnableCancellablePrimeFactorizer r2 = new RunnableCancellablePrimeFactorizer(204,
                                        2, (long) Math.sqrt(204) / 2);
        RunnableCancellablePrimeFactorizer r3 = new RunnableCancellablePrimeFactorizer(204,
                (long) Math.sqrt(204) / 2 + 1, (long) Math.sqrt(204));
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t2.start();
        t3.start();
        try {
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();


       // r2.getPrimeFactors().forEach(p -> System.out.print(p + ", "));
       // r3.getPrimeFactors().forEach(p -> System.out.print(p + ", "));

        System.out.println();
        System.out.println("Cancellable prime factors of 312 ");
        RunnableCancellablePrimeFactorizer r4 = new RunnableCancellablePrimeFactorizer(312, 2, 312);
        Thread t4 = new Thread(r4);
        t4.start();
        r4.setDone();
        try {
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
     //   System.out.println("Cancellable prime factors of 312 ");
      //  r4.getPrimeFactors().forEach(p -> System.out.print(p + ", "));

    }

}
