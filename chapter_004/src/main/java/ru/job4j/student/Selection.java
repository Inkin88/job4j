package ru.job4j.student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Selection {
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().
                sorted(Comparator.comparing(Student::getScope).reversed()).
                flatMap(Stream::ofNullable).
                takeWhile(s -> s.getScope() > bound).collect(Collectors.toList());

    }
}
