package edu.umb.cs681.hw9;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement{
    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime createtime,String ownerName,LocalDateTime lastModified) {
        super(parent, name, size, createtime,ownerName,lastModified);
    }


    @Override
    public boolean isDirectory() {

        return false;
    }

}
