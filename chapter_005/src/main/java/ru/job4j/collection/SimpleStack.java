package ru.job4j.collection;

public class SimpleStack<T> {
    private SimpleLinkedList<T> linked = new SimpleLinkedList<>();

    public T pop() {
        return linked.delete();
    }

    public void push(T value) {
        linked.add(value);
    }

    public int getSize() {
       return linked.getSize();
    }
}
