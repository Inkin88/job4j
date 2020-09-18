package ru.job4j.collection;

public class SimpleStack<T> {
    private SimpleLinkedList<T> linked = new SimpleLinkedList<T>();

    public T pop() {
        T result = linked.get(0);
        linked.delete(result);
        return result;
    }

    public void push(T value) {
        linked.add(value);
    }
}
