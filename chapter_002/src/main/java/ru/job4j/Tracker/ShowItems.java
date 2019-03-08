package ru.job4j.tracker;

public class ShowItems extends BaseActions {

    public ShowItems(int key, String info) {
       super(key, info);
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
}
