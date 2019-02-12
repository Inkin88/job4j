package ru.job4j.tracker;
import java.util.*;

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;
    private static Random RN = new Random();

    /**
     * Метод добавляет заявку в Трекер
     * @param item - заявка.
     * @return зявку.
     */
    public Item add(Item item) {
        item.setId(this.generateId()); // генерируем ID и присваеваем добавляемой заявке.
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод генерирующий Id.
     * @return id
     */
    public String generateId() {
        return String.valueOf(RN.nextInt(100));
    }

    /**
     * Метод заменяющий заявку.
     * @param id номер ид заявки
     * @param item заявка
     * @return измененная заявка
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for(int index = 0; index < this.items.length; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод который возвращает массив заявок без null
     * @return массив
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Метод сравниевает имя.
     * @param key имя
     * @return массив заявок с совпавшими именами
     */
    public Item[] findByName(String key) {
        int count = 0;
        Item[] result = new Item[this.position];
        for (int index = 0; index < this.position; index++) {
            if (result[index].getName().equals(key)) {
                result[count++] = items[index];
            }
        }
        return Arrays.copyOf(result, count);

    }

    /**
     * Метод поиска заявки по Id.
     * @param id - id заявки.
     * @return если такого id нет возвращает null, если есть то найденную заявку.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Удаляет заявку
     * @param id ИД заявки
     * @return удалось ли провести операцию.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                result = true;
                System.arraycopy(items, i + 1, items, i, position - i);
                position--;
                break;
            }
        }
        return result;
    }
}
