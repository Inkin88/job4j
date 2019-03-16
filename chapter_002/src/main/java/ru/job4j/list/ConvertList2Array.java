package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (double) rows);
        int i = 0;
        int[][] array = new int[rows][cells];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cells; y++) {
                if (i == list.size()) {
                    break;
                }
                array[x][y] = list.get(i++);
                }
            }
        return array;
        }
    }
