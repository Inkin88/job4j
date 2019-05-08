package ru.job4j.tracker;

import java.util.function.Consumer;

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
    private final Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions(this);
        do {
            menu.show();
            menu.select(input.ask("select:", menu.getRange()));
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
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
