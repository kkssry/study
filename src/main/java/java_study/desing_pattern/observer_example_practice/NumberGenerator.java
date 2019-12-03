package java_study.desing_pattern.observer_example_practice;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
    private ArrayList observers = new ArrayList();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        Iterator it = observers.iterator();
        while(it.hasNext()) {
            Observer observer = (Observer) it.next();
            observer.update(this);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public abstract int getNum();
    public abstract void execute();
}
