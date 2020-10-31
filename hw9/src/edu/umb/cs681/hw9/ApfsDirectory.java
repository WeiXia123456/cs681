package edu.umb.cs681.hw9;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;


public class ApfsDirectory extends ApfsElement   {

    private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();

    private int totalSize = 0;
    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime createtime, String ownerName,LocalDateTime lastModified) {
        super(parent, name, size, createtime, ownerName, lastModified);

    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public int countChildren() {

        return this.children.size();
    }

    public LinkedList<ApfsElement> getChildren() {
        return this.children;
    }

    public void appendChild(ApfsElement child) {
        this.children.add(child);
    }

    public LinkedList<ApfsDirectory> getSubDirectories(){
        LinkedList<ApfsDirectory> directoryList =  new LinkedList<ApfsDirectory>();
        for(ApfsElement child : children) {
            if (child.isDirectory()) {
                directoryList.add((ApfsDirectory) child);
            }
        }
        return directoryList;
    }

    public LinkedList<ApfsFile> getFiles(){
        LinkedList<ApfsFile> fileList =  new LinkedList<ApfsFile>();
        for(ApfsElement child : children) {
            if (!child.isDirectory()) {
                fileList.add((ApfsFile) child);
            }
        }
        return fileList;
    }

    public int getTotalSize() {
        int total = 0;
        Iterator<ApfsElement> fs = getChildren().iterator();
        while(fs.hasNext()) {
            ApfsElement f = fs.next();
            lock.lock();
            if (!f.isDirectory()) {
                total += f.getSize();
            } else {
                total += ((ApfsDirectory) f).getTotalSize();
            }
            try{
                totalSize = total;
            } finally {
                lock.unlock();
            }
        }
        return totalSize;

    }
}
