package ru.job4j.collectionsort;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortUserTest {
    @Test
    public void sortUsersByAge() {
        List<User> input = new ArrayList<>();
        input.add(new User("Vova", 45));
        input.add(new User("Airat", 30));
        input.add(new User("Zara", 18));
        TreeSet<User> expected = new TreeSet<>(input);
        SortUser users = new SortUser();
        assertThat(expected, is(users.sort(input)));
    }
}
