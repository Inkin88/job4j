package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void reverseMassive() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expected = new int[]{2, 6, 1, 4};
        assertThat(result, is(expected));
    }

    @Test
    public void reverseMassive2() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2, 7};
        int[] result = turner.back(input);
        int[] expected = new int[]{7, 2, 6, 1, 4};
        assertThat(result, is(expected));
    }
}