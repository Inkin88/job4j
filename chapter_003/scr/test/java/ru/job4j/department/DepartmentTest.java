package ru.job4j.department;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentTest {
    @Test
    public void whenMissed() {
        Department deps = new Department();
        List<String> input = Arrays.asList("k1\\sk1", "k2");
        Set<String> expect = new TreeSet<>(Arrays.asList("k1", "k1\\sk1", "k2"));
        Set<String> result = deps.naturalSort(input);
        assertThat(result, is(expect));
    }
    @Test
    public void reverseSort() {
        Department deps = new Department();
        List<String> input = Arrays.asList("k1\\sk1", "k2");
        Set<String> expect = new TreeSet<>(Arrays.asList("k2", "k1", "k1\\sk1"));
        Set<String> result = deps.reverseSort(input);
        assertThat(result, is(expect));

    }
}
