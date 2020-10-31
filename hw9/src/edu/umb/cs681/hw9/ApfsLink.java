package edu.umb.cs681.hw9;

import java.time.LocalDateTime;


public class ApfsLink extends ApfsElement{
    private ApfsElement target;

    public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,LocalDateTime lastModified,ApfsElement target) {
        super(parent,name,size,creationTime,ownerName,lastModified);
        this.target = target;

    }

    public ApfsElement getTarget() {
        lock.lock();
        try {
            return this.target;
        } finally {
            lock.unlock();
        }
    }

    public void setTarget(ApfsElement target) {
        lock.lock();
        try{
            this.target = target;
        } finally {
            lock.unlock();
        }
    }
    public boolean isApfsLink() {
        return true;
    }

    public int getTargetSize() {
        lock.lock();
        try {
            return this.target.getSize();
        } finally {
            lock.unlock();
        }

    }

    public int getTargetChildrenNumber() {
        lock.lock();
        try {
            if (target.isDirectory()) {
                return ((ApfsDirectory) target).countChildren();
            }
        } finally {
            lock.unlock();
        }
        return 0;
    }

    @Override
    public boolean isDirectory(){
        return false;
    }

    @Override
    public boolean isLink(){
        return true;
    }
}

