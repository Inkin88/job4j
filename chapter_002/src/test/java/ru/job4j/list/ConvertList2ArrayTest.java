package ru.job4j.list;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConvertList2ArrayTest {
    @Test
    public void convertListToArray3on3() {
        ConvertList2Array convert = new ConvertList2Array();
        int [][] result = convert.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void convertArraysToList() {
        ConvertList2Array IntegerList = new ConvertList2Array();
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{1, 2, 3});
        input.add(new int[]{4, 5, 6, 7});
        List<Integer> result = IntegerList.converter(input);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThat(result, is(expected));


    }
}
