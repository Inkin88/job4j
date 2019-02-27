package ru.job4j.tracker;

public class UpdateItem implements UserAction {
    int key;
    String info;
    public UpdateItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Меняем заявку ------------");
        String id = input.ask("Введите id заявки:");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        boolean result = tracker.replace(id, item);
        if (result) {
            System.out.println("------------ Заявка изменена. ------------" + item);
        } else {
            System.out.println("Нет такой заявки с таким id");
        }
    }
    @Override
    public String info() {
        return this.info;
    }

}
