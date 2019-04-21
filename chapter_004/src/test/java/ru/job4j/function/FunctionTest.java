package ru.job4j.function;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

public class FunctionTest {
    Function function = new Function();
    @Test
    public void whenLinearFunctionThenLinearResult() {
        List<Double> result = function.diapason(1, 2, x -> x * 2 + 5);
        List<Double> expected = Arrays.asList(7D, 9D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSqrtFunctionThenSqrtResult() {
        List<Double> result = function.diapason(1, 3, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(1D, 4D, 9D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenLogFunctionThenLogResult() {
        List<Double> result = function.diapason(2, 5, x -> Math.floor(Math.log10(x)) + x);
        List<Double> expected = Arrays.asList(2D, 3D, 4D, 5D);
        assertThat(result, is(expected));
    }
}
