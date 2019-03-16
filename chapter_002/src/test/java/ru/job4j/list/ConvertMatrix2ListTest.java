package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConvertMatrix2ListTest {
    @Test
    public void matrixThenList() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        List<Integer> expect = Arrays.asList(1, 2, 3, 4);
        int[][] input = {
                {1,2},
                {3,4}
        };
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}
