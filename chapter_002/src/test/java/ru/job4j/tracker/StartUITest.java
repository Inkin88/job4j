package ru.job4j.tracker;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void userFindAllCreatedItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test desc"));
        Item item2 = tracker.add(new Item("test name 2", "test desc2"));
        List<Item> result = tracker.findAll();
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(result));
    }
    @Test
    public void userDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test desc"));
        Item item2 = tracker.add(new Item("test name 2", "test desc2"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(tracker.findByName("test name 2")));
    }
    @Test
    public void userFindItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }
    @Test
    public void userFindItemByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test desc"));
        List<Item> result = tracker.findByName("test name");
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()), is(result));
    }
}