package edu.umb.cs681.hw9;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class ApfsElement extends FSElement{
    protected String ownerName;
    protected LocalDateTime lastModified;



    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime createtime,String ownerName,LocalDateTime lastModified) {
        super(parent,name,size,createtime);
        this.ownerName = ownerName;
        this.lastModified = lastModified;

    }

    public String getOwnerName() {
        lock.lock();
        try {
            return this.ownerName;
        } finally {
            lock.unlock();
        }
    }

    public void setOwnerName(String ownerName) {
        lock.lock();
        try {
            this.ownerName = ownerName;
        } finally {
            lock.unlock();
        }
    }



    public LocalDateTime getLastModified() {
        lock.lock();
        try {
            return this.lastModified;
        } finally {
            lock.unlock();
        }
    }

    public void setLastModified(LocalDateTime lastModified) {
        lock.lock();
        try {
            this.lastModified = lastModified;
        } finally {
            lock.unlock();
        }
    }


}
