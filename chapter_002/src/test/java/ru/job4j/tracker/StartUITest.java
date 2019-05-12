package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StartUITest {
    private Tracker tracker;
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };
    private final String menu = new StringJoiner(System.lineSeparator())
            .add("0. Add item.")
            .add("1. Show all items.")
            .add("2. Update item.")
            .add("3. Delete item.")
            .add("4. Find item by id.")
            .add("5. Find item by name.")
            .add("6. Exit.")
            .add("")
            .toString();
    private StringBuilder builder;
    @Before
    public void itemAdd() {
        tracker = new Tracker();
        tracker.add(new Item("test name1", "test desc1"));
        tracker.add(new Item("test name2", "test desc2"));
        tracker.add(new Item("test name3", "test desc3"));
        System.setOut(new PrintStream(out));
        builder = new StringBuilder();
        builder.append(menu);
    }
    @After
    public void backOutput() {
        System.setOut(new PrintStream(stdout));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        //  Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name1", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name1")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        // Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        // Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", tracker.findAll().get(0).getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(tracker.findAll().get(0).getId()).getName(), is("test replace"));
    }
    @Test
    public void userFindAllCreatedItems() {
        // Tracker tracker = new Tracker();
        // Item item = tracker.add(new Item("test name", "test desc"));
        // Item item2 = tracker.add(new Item("test name 2", "test desc2"));
        //  List<Item> result = tracker.findAll();
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().size(), is(3));
    }
    @Test
    public void userDeleteItem() {
        // Tracker tracker = new Tracker();
        // Item item = tracker.add(new Item("test name", "test desc"));
        //  Item item2 = tracker.add(new Item("test name 2", "test desc2"));
        Input input = new StubInput(new String[]{"3", tracker.findAll().get(0).getId(), "6"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name2"));
    }
    @Test
    public void userFindItemById() {
        // Tracker tracker = new Tracker();
        //   Item item = tracker.add(new Item("test name", "test desc"));
        Input input = new StubInput(new String[]{"4", tracker.findAll().get(2).getId(), "6"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(tracker.findAll().get(2).getId()), is(tracker.findAll().get(2)));
    }
    @Test
    public void userFindItemByName() {
        // Tracker tracker = new Tracker();
        // Item item = tracker.add(new Item("test name", "test desc"));
        List<Item> result = tracker.findByName("test name2");
        List<Item> expected = new ArrayList<>();
        expected.add(tracker.findAll().get(1));
        Input input = new StubInput(new String[]{"5", tracker.findAll().get(1).getName(), "6"});
        new StartUI(input, tracker, output).init();
        assertThat(expected, is(result));
    }
    @Test
    public void whenShowAll() {
        String[] action = {"1", "6"};
        builder.append(String.format("------------ All items: ------------%n"));
        for (Item item : tracker.findAll()) {
            builder.append(String.format("Item: [id = " + item.getId() + ", name = " + item.getName() + ", desc:" + item.getDesc() + ", created: " + item.getCreated() + "]%n"));
        }
        builder.append(String.format("Items not added, please create item.%n"));
        builder.append(menu);
        new StartUI(new StubInput(action), tracker, output).init();
        assertThat(out.toString(), is(builder.toString()));
    }
    @Test
    public void addingNewItem() {
        String[] action = {"0", "test", "test", "6"};
        new StartUI(new StubInput(action), tracker, output).init();
        builder.append(String.format("------------ Adding new item --------------%n"));
        builder.append(String.format("------------ New Item with Id : %s%n", tracker.findAll().get(3).getId()));
        builder.append(String.format("------------ New Item with Name : test%n"));
        builder.append(String.format("------------ New Item with Description : test%n"));
        builder.append(menu);
        assertThat(out.toString(), is(builder.toString()));
    }
    @Test
    public void findItemByName() {
        String[] action = {"5", "test name1", "6"};
        builder.append(String.format("------------ Ищем заявку по имени ------------%n"));
        builder.append(String.format("Найденные заявки: ["));
        for (Item item : tracker.findByName("test name1")) {
            builder.append(String.format("Item: [id = " + item.getId() + ", name = " + item.getName() + ", desc:" + item.getDesc() + ", created: " + item.getCreated() + "]"));
        }
        builder.append(String.format("]%n"));
        builder.append(menu);
        new StartUI(new StubInput(action), tracker, output).init();
        assertThat(out.toString(), is(builder.toString()));
    }
}