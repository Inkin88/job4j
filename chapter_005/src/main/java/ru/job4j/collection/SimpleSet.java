package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {

    private SimpleArray<T> simpleArray;

    public SimpleSet(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    public void add(T t) {
        boolean isContain = false;
        for (T t1 : simpleArray) {
            if (t.equals(t1)) {
                isContain = true;
                break;
            }
        }
        if (!isContain) {
            simpleArray.add(t);
        }
    }

    public int getSize() {
        return simpleArray.getElementsCount();
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}
