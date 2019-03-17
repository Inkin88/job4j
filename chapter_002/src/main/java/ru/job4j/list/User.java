package ru.job4j.list;

/**
 * @author Airat Muzafarov.
 * @version 0.1
 * @since 17.03.2019
 */

public class User {
    /**
     * Класс Юзер со значениями id, name, city.
     */
    private int id;
    private String name;
    private String city;
    public User(int id, String name, String city) {
        this.id = id;
        this.city = city;
        this.name = name;
    }
    public int getUserId() {
        return this.id;
    }
    public String getUserName() {
        return this.name;
    }
    public String getUserCity() {
        return this.city;
    }
}
