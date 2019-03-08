package ru.job4j.tracker;

public class DeleteItem extends BaseActions {
    public DeleteItem(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаляем заявку ------------");
        String id = input.ask("Введите id заявки, которую хотите удалить: ");
        boolean result = tracker.delete(id);
        if (result) {
            System.out.println("------------Заявка удалена. ------------");
        } else {
            System.out.println("Нет такой заявки с таким id");
        }


    }
}