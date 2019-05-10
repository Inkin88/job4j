package ru.job4j.tracker;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;


public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private final Consumer<String> output;

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI start) {
        this.actions.add(new AddItem(0, "0. Add item."));
        this.actions.add(new ShowItems(1, "1. Show all items."));
        this.actions.add(new UpdateItem(2, "2. Update item."));
        this.actions.add(new DeleteItem(3, "3. Delete item."));
        this.actions.add(new FindItemById(4, "4. Find item by id."));
        this.actions.add(new FindItemsByName(5, "5. Find item by name."));
        this.actions.add(new ExitProgram(6, "6. Exit.", start));
    }
    public int[] getRange() {
        int[] range = new int[this.actions.size()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
        return range;
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }
}
