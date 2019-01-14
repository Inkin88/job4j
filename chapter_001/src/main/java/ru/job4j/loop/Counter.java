package ru.job4j.loop;
/**
 * Класс суммирует все четные числа из диапазона.
 * @author Airat Muzafarov.
 * @version $Id$.
 * @since 0.1
 */
public class Counter {
    /**
     * Метод суммирует все четные числа из диапазона.
     *
     * @param start  - начало диапазона.
     * @param finish - конец диапазона.
     * @return сумму четных чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) sum = sum + i;
        }
        return sum;
    }
}