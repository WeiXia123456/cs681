package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;

public class Customer {
    private Address address;
    ReentrantLock lock = new ReentrantLock();

    public Customer(Address address) {

        this.address = address;

    }

    public void setAddress(Address address) {
        lock.lock();
        try {
            this.address = address;
        } finally {
            lock.unlock();
        }

    }

    public Address getAddress() {
        lock.lock();
        try {
            return this.address;
        } finally {
            lock.unlock();
        }

    }
}
