package ru.job4j.tracker;

public class UpdateItem extends BaseActions {
    public UpdateItem(int key, String info) {
       super(key, info);
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
}
