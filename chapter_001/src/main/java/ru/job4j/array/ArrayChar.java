package ru.job4j.array;


/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        char[] value = prefix.toCharArray();
        int minLength = Math.min(value.length, data.length);
        for (int i = 0; i < minLength; i++) {
            if (data[i] != value[i]) {
                return false;
            }
        }
        return true;
    }
}
