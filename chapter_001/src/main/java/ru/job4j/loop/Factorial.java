package ru.job4j.loop;

/**
 * Класс для вычисления факториала.
 * @author Airat Muzafarov
 * @version ID
 * @since 0.1
 */
public class Factorial {
    /**
     * Метод вычисляет факториал.
     * @param n число для которого нужно посчитать фаториал.
     * @return результат.
     */
    public int calc(int n) {
        if (n==0) return 1;
        int fact = 1;
        for (int i=1; i<=n; i++) fact = fact * i;
        return fact;
    }
}