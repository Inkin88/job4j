package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StoreTest {

    Store<User> userStore;
    Store<Role> roleStore;

    @Before
    public void setUp() {
        userStore = new UserStore(3);
        userStore.add(new User("One"));
        userStore.add(new User("Two"));
        userStore.add(new User("Three"));
        roleStore = new RoleStore(3);
        roleStore.add(new Role("First"));
        roleStore.add(new Role("Second"));
        roleStore.add(new Role("Third"));
    }
    @Test
    public void addElements() {
        assertThat(userStore.toString(), is("[One, Two, Three]"));
        assertThat(roleStore.toString(), is("[First, Second, Third]"));
    }
    @Test
    public void replaceElement() {
       boolean isTrueForUserStore = userStore.replace("One", new User("OneOne"));
       boolean isTrueForRoleStore = roleStore.replace("Second", new Role("SecondSecond"));
       assertThat(isTrueForRoleStore, is(true));
       assertThat(isTrueForUserStore, is(true));
       assertThat(userStore.toString(), is("[OneOne, Two, Three]"));
       assertThat(roleStore.toString(), is("[First, SecondSecond, Third]"));
    }
    @Test
    public void deleteElement() {
        boolean isTrueForUserStore = userStore.delete("One");
        boolean isTrueForRoleStore = roleStore.delete("Second");
        assertThat(isTrueForRoleStore, is(true));
        assertThat(isTrueForUserStore, is(true));
        assertThat(userStore.toString(), is("[Two, Three]"));
        assertThat(roleStore.toString(), is("[First, Third]"));
    }
    @Test
    public void findElement() {
        User result = userStore.findById("Three");
        Role result2 = roleStore.findById("First");
        assertThat(result.toString(), is("Three"));
        assertThat(result2.toString(), is("First"));
    }
}
