package ru.job4j.tracker;


public class FindItemById extends BaseActions {
    public FindItemById(int key, String info) {
        super(key, info);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Ищем заявку по ID. -------------");
        String id = input.ask("Введите ID заявки, которую хотите найти: ");
        Item result = tracker.findById(id);
        if (result == null) {
            System.out.println("Заявки с таким ID нет");
        } else {
            System.out.println("------------ Найденная заявка: " + result);
        }
    }

}
