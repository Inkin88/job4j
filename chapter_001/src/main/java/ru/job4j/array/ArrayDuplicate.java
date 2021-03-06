package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс удаляет все дубликаты из массива.
 *
 * @author Airat Muzafarov.
 * @version 0.1.
 * @since 23.01.2019.
 */

public class ArrayDuplicate {
    /**
     * Метод отбрасывающий дубликаты элементов.
     *
     * @param array исходный массив.
     * @return массив без повторений.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
