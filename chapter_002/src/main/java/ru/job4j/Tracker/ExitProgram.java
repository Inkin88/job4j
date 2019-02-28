package ru.job4j.tracker;

public class ExitProgram implements UserAction {
    public StartUI start;
    int key;
    String info;
    public ExitProgram(int key, String info, StartUI start) {
        this.key = key;
        this.info = info;
        this.start = start;
    }
    @Override
    public int key() {
        return this.key;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        this.start.stop();
    }
    @Override
    public String info() {
        return this.info;
    }
}
