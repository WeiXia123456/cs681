package edu.umb.cs681.hw9;

import java.time.LocalDateTime;
import java.util.LinkedList;
public class FileSystem {
    protected String name;
    protected int capacity;
    protected int id;
    static private FileSystem instance = null;
    static LocalDateTime date = LocalDateTime.now();
    private LinkedList<FSElement> rootDirs = new LinkedList<FSElement>();


    public static FileSystem getInstance() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public FSElement initFileSystem(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if(root.isDirectory() && capacity >= root.getSize()){
            setRoot(root);
            this.id = root.hashCode();
            return root;
        }
        else{
            return null;
        }
    }


    protected FSElement createDefaultRoot() {
        return new FSElement(null, "root", 0,date );
    }

    public void setRoot(FSElement root) {
        rootDirs.add(root);
    }


    public int getCapacity() {
        return this.capacity;
    }


    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public LinkedList<FSElement> getRootDir(){
        return this.rootDirs;
    }

}
