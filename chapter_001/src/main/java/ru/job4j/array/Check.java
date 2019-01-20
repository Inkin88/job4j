package ru.job4j.array;

/**
 * Класс проверяет значение всех элементов в булиановском массиве на true или false.
 * @author Airat Muzafarov.
 * @version 0.1
 * @since 20.01.2019
 */

public class Check {
    /**
     * Метод проверяющий массив.
     * @param data - массив.
     * @return значение true или false.
     */
    public boolean mono(boolean[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
                return false;
            }
        }
        return true;
    }
}