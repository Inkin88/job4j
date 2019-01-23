package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Тест
 *
 * @author Airat Muzafarov.
 * @version 0.1.
 * @since 23.01.19.
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicateThenArrayWhithOutDuplicate() {
        String[] input = {"Olga", "Vasya", "Lena", "Lena"};
        String[] expect = {"Olga", "Vasya", "Lena"};
        ArrayDuplicate arr = new ArrayDuplicate();
        String[] result = arr.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}