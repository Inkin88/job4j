package ru.job4j.collectionsort;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Airat Muzafarov
 * @since 25/03/2019
 * @version 0.1
 */

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
    @Test
    public void sortUsersByNameLength() {
        List<User> input = new ArrayList<>();
        input.add(new User("Benjamin", 20));
        input.add(new User("Kate", 29));
        input.add(new User("Vladimirr", 29));
        input.add(new User("Marat", 55));
        List<User> expected = new ArrayList<>();
        expected.add(new User("Kate", 29));
        expected.add(new User("Marat", 55));
        expected.add(new User("Benjamin", 20));
        expected.add(new User("Vladimirr", 29));
        SortUser users = new SortUser();
        List<User> result = users.sortNameLength(input);
        assertThat(result, is(expected));
    }
    @Test
    public void sortUsersByAllFields() {
        List<User> input = new ArrayList<>();
        input.add(new User("Benjamin", 20));
        input.add(new User("Kate", 29));
        input.add(new User("Vladimir", 29));
        input.add(new User("Marat", 55));
        List<User> expected = new ArrayList<>();
        expected.add(new User("Benjamin", 20));
        expected.add(new User("Kate", 29));
        expected.add(new User("Marat", 55));
        expected.add(new User("Vladimir", 29));
        SortUser users = new SortUser();
        List<User> result = users.sortByAllFields(input);
        assertThat(result, is(expected));
    }

}
