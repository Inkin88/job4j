package ru.job4j.tracker;

public class ExitProgram implements UserAction {
    int key;
    String info;
    public ExitProgram(int key, String info) {
        this.key = key;
        this.info = info;
    }
    @Override
    public int key() {
        return this.key;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.exit(0);
    }
    @Override
    public String info() {
        return this.info;
    }
}
