package org.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lj
 * @version 1.0.0
 * @Description 可观察对象接口
 * @createTime 2021-11-04 17:15
 */
public abstract class Observable {

    protected List<Observer> observers = new ArrayList<>();


    protected void addObserver(Observer observer) {
        Optional.of(observer).ifPresent(obs -> observers.add(obs));
    }


    protected void deleteObserver(Observer observer) {
        Optional.of(observer).ifPresent(obs -> observers.remove(obs));
    }

    protected void notifyAllObservers(String name) {
        observers.stream().forEachOrdered(observer -> {
            observer.doSomething(name);
        });
    }

}
