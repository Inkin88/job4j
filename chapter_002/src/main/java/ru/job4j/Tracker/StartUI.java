package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findByIdItem();
            } else if (FINDNAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    private void showAllItems() {
        System.out.println("------------ Все заявки: ------------");
        for (Item items : this.tracker.findAll())
            System.out.println(items);
        if (tracker.position == 0) {
            System.out.println("Заявок нет, создайте заявку!");
        }
        }

    private void editItem() {
        System.out.println("------------ Меняем заявку ------------");
        String id = this.input.ask("Введите id заявки:");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        boolean result = this.tracker.replace(id, item);
        if (result) {
            System.out.println("------------ Заявка изменена. ------------" + item);
        } else {System.out.println("Нет такой заявки с таким id"); }
        }

    private void deleteItem() {
        System.out.println("------------ Удаляем заявку ------------");
        String id = this.input.ask("Введите id заявки, которую хотите удалить: ");
        boolean result = this.tracker.delete(id);
        if (result) {
            System.out.println("------------Заявка удалена. ------------");
        } else {
            System.out.println("Нет такой заявки с таким id");
        }
    }
    private void findByIdItem() {
        System.out.println("------------ Ищем заявку по ID. -------------");
        String id = this.input.ask("Введите ID заявки, которую хотите найти: ");
        Item result = this.tracker.findById(id);
        if (result == null) {
            System.out.println("Заявки с таким ID нет");
        } else {
            System.out.println("------------ Найденная заявка: " + result);
        }
    }
    private void findByNameItem() {
        System.out.println("------------ Ищем заявку по имени ------------");
        String key = this.input.ask("Введите имя заявки, которую хотите найти: ");
        Item[] result = this.tracker.findByName(key);
        System.out.println("Найденные заявки: " + Arrays.toString(result));
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить заявку.");
        System.out.println("1. Показать все заяки.");
        System.out.println("2. Поменять заявку.");
        System.out.println("3. Удалить заявку.");
        System.out.println("4. Найти заявку по ID.");
        System.out.println("5. Найти заявку по имени.");
        System.out.println("6. Выход из программы.");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
