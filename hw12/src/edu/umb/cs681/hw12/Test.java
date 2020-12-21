package edu.umb.cs681.hw12;

public class Test implements Runnable {
    private Customer cus;

    public Test(Address address) {
        cus = new Customer(address);
    }
    @Override
    public void run() {
        System.out.println("current address is: ");
        System.out.print(cus.getAddress());
        System.out.println("");
        cus.setAddress(new Address("Hancock", "Quincy", "MA", 02171));
        System.out.println("Change address to: ");
        System.out.println(cus.getAddress());

    }


    public static void main(String[] args) {
        Address a1 = new Address("Morrissy", "Boston", "MA", 02125);
        Address a2 = new Address("caladity", "MountainView", "CA", 94035);

        Thread t1 = new Thread(new Test(a1));
        Thread t2 = new Thread(new Test(a2));
        System.out.println("Thread 1: ");
        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thread 2: ");
        t2.start();
        try {
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

