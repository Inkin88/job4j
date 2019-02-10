package ru.job4j.array;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayMergeTest {
    @Test
    public void whenTwoArraysGetOneShortedArray() {
        ArrayMerge arr = new ArrayMerge();
        int[] input1 = new int[] {2, 5, 7, 6, 4};
        int[] input2 = new int[] {3, 8, 1, 9};
        int[] result = arr.merge(input1, input2);
        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(result, is(expected));
    }
}
