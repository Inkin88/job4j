package ru.job4j.student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SelectionTest {
    @Test
    public void selectStudent() {
        Student st1 = new Student("Airat", 56);
        Student st2 = new Student("Bulat", 33);
        Student st3 = new Student("Vova", 68);
        Student st4 = new Student();
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        Selection select = new Selection();
        List<Student> result = select.levelOf(students, 50);
        List<Student> expect = Arrays.asList(st3, st1);
        assertThat(result, is(expect));

    }
}
