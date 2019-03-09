package ru.job4j.patterns;
import org.junit.Test;
import org.junit.Before;
import ru.job4j.tracker.Item;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerSingletonTests {
    private Item[] items = new Item[5];
    @Before
    public void init() {
        items[0] = new Item("test", "test");
        items[1] = new Item("test1", "test1");
        items[2] = new Item("test2", "test2");
        items[3] = new Item("test3", "test3");
        items[4] = new Item("test4", "test4");
    }
    @Test
    public void trackerSingletonTest1() {
        TrackerSingletonEnum instance = TrackerSingletonEnum.INSTANCE;
        for (Item item : items) {
            instance.add(item);
        }
        TrackerSingletonEnum expected = TrackerSingletonEnum.INSTANCE;
        assertThat(expected.findAll(), is(items));

    }
    @Test
    public void trackerSingletonTest2() {
        TrackerSingletonPrivateStaticFinalClass instance = TrackerSingletonPrivateStaticFinalClass.getInstance();
        for (Item item : items) {
            instance.add(item);
        }
        TrackerSingletonPrivateStaticFinalClass expected = TrackerSingletonPrivateStaticFinalClass.getInstance();
        assertThat(expected.findAll(), is(items));
    }
    @Test
    public void trackerSingletonTest3() {
        TrackerSingletonStaticFinalFieldEagerLoading instance = TrackerSingletonStaticFinalFieldEagerLoading.getINSTANCE();
        for (Item item : items) {
            instance.add(item);
        }
        TrackerSingletonStaticFinalFieldEagerLoading expected = TrackerSingletonStaticFinalFieldEagerLoading.getINSTANCE();
        assertThat(expected.findAll(), is(items));
    }
    @Test
    public void trackerSingletonTest4() {
        TrackerSingletonStaticFieldLazyLoading instance = TrackerSingletonStaticFieldLazyLoading.getInstance();
        for (Item item : items) {
            instance.add(item);
        }
        TrackerSingletonStaticFieldLazyLoading expected = TrackerSingletonStaticFieldLazyLoading.getInstance();
        assertThat(expected.findAll(), is(items));
    }


}
