package ru.job4j.max;

/**
 * @author Airat Muzafarov/
 * @version $Id$.
 * @since 0.1.
 */


public class Max {
    /**
     * Сравнивает два числа и возвращает максимальное.
     * @param first первое число.
     * @param second второе число.
     * @return максимально число.
     */
    public int max(int first, int second) {
        int maximum = first < second ? second : first;
        return maximum;

    }

}
