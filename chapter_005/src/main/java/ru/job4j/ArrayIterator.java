package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Airat Muzafarov
 * @version 0.1
 * @since 19/05/19
 */

public class ArrayIterator implements Iterator {
    private final int[][] matrix;
    private int indexX;
    private int indexY;

    public ArrayIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        if (matrix[indexX].length == indexY) {
            indexX++;
            indexY = 0;
        }
        return matrix.length > indexX;
    }

    @Override
    public Object next() {
        if (matrix.length == indexX) {
            throw new NoSuchElementException();
        }
        if (matrix[indexX].length == indexY) {
            indexX++;
            indexY = 0;
        }
        return matrix[indexX][indexY++];
    }
}

