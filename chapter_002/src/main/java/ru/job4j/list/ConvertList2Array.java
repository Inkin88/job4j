package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int x = 0;
        int y = 0;
        for (int i : list) {
            if (y == cells) {
                x++;
                y = 0;
            }
            array[x][y++] = i;
        }
        return array;
    }

    public List<Integer> converter(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] x : list) {
            for (int y : x) {
                result.add(y);
            }
        }
        return result;
    }
}

