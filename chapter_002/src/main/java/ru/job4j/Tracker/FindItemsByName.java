package ru.job4j.tracker;

import java.util.List;

public class FindItemsByName extends BaseActions {
    public FindItemsByName(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Ищем заявку по имени ------------");
        String key = input.ask("Введите имя заявки, которую хотите найти: ");
        List<Item> result = tracker.findByName(key);
        System.out.println("Найденные заявки: " + result);
    }
}
