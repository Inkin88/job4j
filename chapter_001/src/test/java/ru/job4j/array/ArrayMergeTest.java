package ru.job4j.array;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тест
 * @author Airat Muzafarov.
 * @version 0.1.
 * @since 10.02.2019.
 */

public class ArrayMergeTest {
    @Test
    public void whenTwoArraysGetOneShortedArray() {
        ArrayMerge arr = new ArrayMerge();
        int[] input1 = new int[] {1, 3, 5, 8, 9};
        int[] input2 = new int[] {2, 4, 6, 7};
        int[] result = arr.merge(input1, input2);
        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(result, is(expected));
    }
}
