package ru.job4j.tracker;

public abstract class BaseActions implements UserAction {
    private final int key;
    private final String info;
    protected BaseActions(final int key, final String info) {
        this.key = key;
        this.info = info;
    }
    @Override
    public int key() {
        return this.key;
    }
    @Override
    public String info() {
        return this.info;
    }



}
