package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {

    private SimpleArray<T> simpleArray;

    public SimpleSet(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    public void add(T t) {
        if (!isContains(t)) {
            simpleArray.add(t);
        }
    }

    public int getSize() {
        return simpleArray.getElementsCount();
    }

    private boolean isContains(T t) {
        boolean isContain = false;
        for (T t1 : simpleArray) {
            if (Objects.equals(t1, t)) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}
