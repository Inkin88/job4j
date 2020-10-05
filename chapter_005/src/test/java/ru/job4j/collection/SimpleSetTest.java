package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    private SimpleSet<String> simpleSet = new SimpleSet<>(new SimpleArray<>());

    @Test
    public void addToSetThreeElements() {
        simpleSet.add("One");
        simpleSet.add("Two");
        simpleSet.add("Three");
        assertThat(simpleSet.getSize(), is(3));
        simpleSet.add("One");
        assertThat(simpleSet.getSize(), is(3));
    }

    @Test
    public void addElementAndGetIterator() {
        simpleSet.add("One");
        simpleSet.add("Two");
        simpleSet.add("Three");
        Iterator<String> it = simpleSet.iterator();
        String rs1 = it.next();
        String rs2 = it.next();
        String rs3 = it.next();
        assertThat(rs1, is("One"));
        assertThat(rs2, is("Two"));
        assertThat(rs3, is("Three"));
    }
}