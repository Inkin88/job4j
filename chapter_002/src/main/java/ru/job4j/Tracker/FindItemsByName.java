package ru.job4j.tracker;

import java.util.Arrays;

public class FindItemsByName implements UserAction {
    int key;
    String info;
    public FindItemsByName(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Ищем заявку по имени ------------");
        String key = input.ask("Введите имя заявки, которую хотите найти: ");
        Item[] result = tracker.findByName(key);
        System.out.println("Найденные заявки: " + Arrays.toString(result));
    }
    @Override
    public String info() {
        return this.info;
    }
}
