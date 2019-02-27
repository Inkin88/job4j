package ru.job4j.tracker;


public class FindItemById implements UserAction {
    int key;
    String info;
    public FindItemById(int key, String info) {
        this.key = key;
        this.info = info;
    }
    @Override
    public int key() {
        return this.key;
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
    @Override
    public String info() {
        return this.info;
    }

}
