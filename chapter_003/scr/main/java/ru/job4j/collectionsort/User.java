package ru.job4j.collectionsort;

import java.util.Objects;

/**
 * @author Airat Muzafarov
 * @since 25/03/19
 * @version 0.1
 */

public class User implements Comparable<User> {
    private String name;
    private Integer age;
    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    /**
     * Сравнивает user по возрасту
     * @param o user
     * @return наименьший возраст.
     */
    @Override
    public int compareTo(User o) {
        return age.compareTo(o.getAge());
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}