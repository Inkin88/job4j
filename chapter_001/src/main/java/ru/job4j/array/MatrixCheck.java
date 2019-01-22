package ru.job4j.array;
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int leftDiagonal = 0; // решение посмотрел в инете не понимаю для чего тут вводятся эти переменные.
        int rightDiagonal = 0;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] == data[i + 1][i + 1]) {
                leftDiagonal++;
            }
            if (data[data.length - 1][data.length - 1] == data[data.length - 1 - i][data.length - 1 - i]) {
                rightDiagonal++;
            }
        }
        return leftDiagonal == data.length - 1 || rightDiagonal == data.length - 1; // эту строчку не понял
    }
}