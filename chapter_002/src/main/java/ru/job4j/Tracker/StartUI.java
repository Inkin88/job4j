package ru.job4j.tracker;
/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private boolean working = true;

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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("select:")));
        } while (this.working);
    }
    public void stop() {
        this.working = false;
    }

    /**
     * Запускт программы.
     * @param args вводные данные.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
