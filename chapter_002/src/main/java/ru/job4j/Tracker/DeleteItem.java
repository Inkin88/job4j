package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    int key;
    String info;
    public DeleteItem(int key, String info) {
        this.key = key;
        this.info = info;
    }
    @Override
    public int key() {
        return this.key;
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
    @Override
    public String info() {
        return this.info;
    }
}
