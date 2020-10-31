
package edu.umb.cs681.hw1;

import java.util.LinkedList;


public abstract class Observable {
    private LinkedList<Observer> observers = new LinkedList<>();
    private boolean changed;

    public Observable(){}

    public void addObserver(Observer obj) {
        if (obj != null && !observers.contains(obj)) {
            observers.add(obj);
        }
    }

    public void deleteObserver(Observer obj) {
        observers.remove(obj);
    }

    public int countObservers() {
        return observers.size();
    }
    protected void setChanged() {
        changed = true;
    }

    protected void clearChanged() {
        changed = false;
    }
    public boolean hasChanged() {
        return changed == true;
    }

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(Object obj) {
        if (changed) {
            for (Observer o : observers) {
                o.update(this, obj);
            }
        }
        clearChanged();
    }
}
