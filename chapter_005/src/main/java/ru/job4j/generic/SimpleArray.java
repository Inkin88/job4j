package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Airat Muzafarov
 * @since 30/05/2019
 * @version 0.1
 */
public class SimpleArray<T> implements Iterable<T> {

    Object[] array;
    int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Iterator for array.
     * @return Iterator.
     */

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int count = 0;

            /**
             * Checks whether there is a next element
             * @return true or false.
             */
            @Override
            public boolean hasNext() {
                return count < index;
            }

            /**
             * Returns the current element and moves to the next one, if not, an exception is thrown
             * NoSuchElementException.
             * @return current element.
             */

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[count++];
            }
        };
    }

    /**
     * Add T elements to array.
     * @param model element
     */
    public void add(T model) {
        if (index == array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[index++] = model;
    }

    /**
     * Changed element.
     * @param index2 of changed element.
     * @param model element.
     */
    public void set(int index2, T model) {
        if (index2 >= index && index2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index2] = model;
    }

    /**
     * Getting an element by index.
     * @param index2 of element.
     * @return element.
     */
    public T get(int index2) {
        if (index2 >= index && index2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index2];
    }

    /**
     * Remove an item by index and shift all items to the left.
     * @param index2 of the element to be deleted.
     */
    public void remove(int index2) {
        System.arraycopy(array, index2 + 1, array, index2, array.length - 1 - index2);
        index--;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, index));
    }
}
