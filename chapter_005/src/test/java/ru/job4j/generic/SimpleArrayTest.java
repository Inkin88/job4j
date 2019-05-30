package ru.job4j.generic;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    SimpleArray<Integer> array;

    @Before
    public void setUp() {
        array = new SimpleArray<>(6);
        for (int i = 0; i < 5; i++) {
            array.add(i + 1);
        }
    }

    @Test
    public void addElements() {
        assertThat(array.toString(), is("[1, 2, 3, 4, 5]"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addElementWithIndexOverThenArraySize() {
        array.add(6);
        array.add(7);
    }

    @Test
    public void getElementIndexTwo() {
        assertThat(array.get(2), is(3));
    }

    @Test
    public void changeElementIndexTwo() {
        array.set(2, 10);
        assertThat(array.get(2), is(10));
    }

    @Test
    public void removeElementIndexTwo() {
        array.remove(2);
        assertThat(array.get(2), is(4));
        assertThat(array.toString(), is("[1, 2, 4, 5]"));
    }

    @Test
    public void hasNextAndNextMethodTest() {
        Iterator<Integer> it = array.iterator();
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(1));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(2));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(3));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(4));
        assertThat(it.hasNext(), Matchers.is(true));
        assertThat(it.next(), Matchers.is(5));
        assertThat(it.hasNext(), Matchers.is(false));
    }
}