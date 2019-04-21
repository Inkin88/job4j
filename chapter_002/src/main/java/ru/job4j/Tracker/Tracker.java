package ru.job4j.tracker;
import java.util.*;
import java.util.stream.Collectors;

public class Tracker {

    private List<Item> items = new ArrayList<>();
    public int position = 0;
    private static Random rnid = new Random();

    /**
     * Метод добавляет заявку в Трекер
     * @param item - заявка.
     * @return зявку.
     */
    public Item add(Item item) {
        item.setId(this.generateId()); // генерируем ID и присваеваем добавляемой заявке.
        items.add(item);
        return item;
    }

    /**
     * Метод генерирующий Id.
     * @return id
     */
    public String generateId() {
        return String.valueOf(rnid.nextInt(100));
    }

    /**
     * Метод заменяющий заявку.
     * @param id номер ид заявки
     * @param item заявка
     * @return измененная заявка
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                item.setId(id);
                items.set(index, item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод который возвращает лист заявок
     * @return list
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод сравниевает имя.
     * @param key имя
     * @return list заявок с совпавшими именами
     */
    public List<Item> findByName(String key) {
        return items.stream().filter(item -> item.getName().equals(key)).collect(Collectors.toList());
    }

    /**
     * Метод поиска заявки по Id.
     * @param id - id заявки.
     * @return если такого id нет возвращает null, если есть то найденную заявку.
     */
    public Item findById(String id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Удаляет заявку
     * @param id ИД заявки
     * @return удалось ли провести операцию.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                result = true;
                items.remove(i);
                break;
            }
        }
        return result;
    }
}
