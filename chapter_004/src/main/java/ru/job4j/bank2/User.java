package ru.job4j.bank2;

import java.util.Objects;

/**
 * @author Airat Muzafarov.
 * @version 0.1
 * @since 04/04/2019
 */

public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "User{"
                +
                "name='"
                + name
                + '\''
                +
                ", passport='"
                + passport + '\''
                +
                '}';
    }
}
