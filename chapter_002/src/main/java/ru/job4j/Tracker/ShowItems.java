package ru.job4j.tracker;

public class ShowItems implements UserAction {
    int key;
    String info;
    public ShowItems(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ All items: ------------");
        for (Item items : tracker.findAll()) {
            System.out.println(items); }
        if (tracker.position == 0) {
            System.out.println("Items not added, please create item.");
        }

    }
    @Override
    public String info() {
        return this.info;
    }

}
