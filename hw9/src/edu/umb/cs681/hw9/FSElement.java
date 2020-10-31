package edu.umb.cs681.hw9;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;


public class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime createtime;
    protected FSElement parent;
    protected ReentrantLock lock = new ReentrantLock();

    public FSElement(FSElement parent, String name, int size, LocalDateTime createtime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.createtime = createtime;
    }

    public FSElement getParent() {
        lock.lock();
        try {
            return this.parent;
        } finally {
            lock.unlock();
        }
    }

    public void setParent(FSElement parent) {
        lock.lock();
        try{
            this.parent = parent;
        } finally {
            lock.unlock();
        }
    }

    public String getName() {
        lock.lock();
        try {
            return this.name;
        } finally {
            lock.unlock();
        }
    }

    public void setName(String name) {
        lock.lock();
        try {
            this.name = name;
        } finally {
            lock.unlock();
        }
    }

    public int getSize() {
        lock.lock();
        try {
            return this.size;
        } finally {
            lock.unlock();
        }
    }

    public void setSize(int size) {
        lock.lock();
        try {
            this.size = size;
        } finally {
            lock.unlock();
        }
    }

    public LocalDateTime getCreateTime() {
        return this.createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public boolean isDirectory() {

        return false;
    }

    public boolean isLink() {

        return false;
    }


}
