package ru.job4j.collectionsort;
import org.junit.Test;
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
        List<User> input = List.of(
        new User("Vova", 45),
        new User("Airat", 30),
        new User("Zara", 18));
        TreeSet<User> expected = new TreeSet<>(input);
        SortUser users = new SortUser();
        assertThat(expected, is(users.sort(input)));
    }
    @Test
    public void sortUsersByNameLength() {
        List<User> input = List.of(
        new User("Benjamin", 20),
        new User("Kate", 29),
        new User("Vladimirr", 29),
        new User("Marat", 55));
        List<User> expected = List.of(
        new User("Kate", 29),
        new User("Marat", 55),
        new User("Benjamin", 20),
        new User("Vladimirr", 29));
        SortUser users = new SortUser();
        List<User> result = users.sortNameLength(input);
        assertThat(result, is(expected));
    }
    @Test
    public void sortUsersByAllFields() {
        List<User> input = List.of(
        new User("Benjamin", 20),
        new User("Kate", 29),
        new User("Vladimir", 29),
        new User("Marat", 55));
        List<User> expected = List.of(
        new User("Benjamin", 20),
        new User("Kate", 29),
        new User("Marat", 55),
        new User("Vladimir", 29));
        SortUser users = new SortUser();
        List<User> result = users.sortByAllFields(input);
        assertThat(result, is(expected));
    }

}
