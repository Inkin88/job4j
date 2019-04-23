package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;

public class Function {
    public List<Double> diapason(int start, int end, java.util.function.Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index <= end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}
