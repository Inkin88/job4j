package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private int elementsCount;
    private int modCount = 0;
    Object[] elements;

    public SimpleArray() {
        this.elements = new Object[10];
    }

    public T get(int index) {
      //  Objects.checkIndex(index, elements.length);
        if (index >= elementsCount) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    public void add(T model) {
        modCount++;
        if (elementsCount != elements.length) {
            elements[elementsCount] = model;
            elementsCount++;
        } else {
            elements = Arrays.copyOf(elements, elementsCount + 1);
            elementsCount++;
            elements[elementsCount] = model;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < elementsCount;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elements[index++];
            }
        };
    }
}

