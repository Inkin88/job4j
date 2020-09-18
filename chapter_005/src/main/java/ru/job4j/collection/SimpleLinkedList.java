package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements Iterable<E> {

    private int size;
    private int modCount;
    Node<E> first;

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    public void add(E value) {
        Node<E> newLink = new Node<E>(value);
        newLink.next = first;
        first = newLink;
        size++;
        modCount++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public E delete() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E result = first.data;
        first = first.next;
        modCount++;
        size--;
        return result;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private final int expectedModCount = modCount;
            private Node<E> node = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = node.data;
                node = node.next;
                return data;
            }
        };
    }
}
