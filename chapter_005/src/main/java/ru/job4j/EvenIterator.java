package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private final int[] num;
    private int index = 0;

    public EvenIterator(int[] num) {
        this.num = num;
    }

    @Override
    public boolean hasNext() {
        for (; index < num.length; index++) {
            if (num[index] % 2 == 0) {
                break;
            }
        }
        return index < num.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return num[index++];
    }
}
