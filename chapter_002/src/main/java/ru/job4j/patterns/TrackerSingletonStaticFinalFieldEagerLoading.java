package ru.job4j.patterns;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;

public class TrackerSingletonStaticFinalFieldEagerLoading {
    private static final TrackerSingletonStaticFinalFieldEagerLoading INSTANCE = new TrackerSingletonStaticFinalFieldEagerLoading();
    private TrackerSingletonStaticFinalFieldEagerLoading() {

    }

    public static TrackerSingletonStaticFinalFieldEagerLoading getINSTANCE() {
        return INSTANCE;
    }
    private Tracker tracker = new Tracker();
    public Item add(Item item) {
        return tracker.add(item);
    }
    public String generateId() {
        return tracker.generateId();
    }
    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }
    public List<Item> findAll() {
        return tracker.findAll();
    }
    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }
    public Item findById(String id) {
        return tracker.findById(id);
    }
    public boolean delete(String id) {
        return tracker.delete(id);
    }
}
