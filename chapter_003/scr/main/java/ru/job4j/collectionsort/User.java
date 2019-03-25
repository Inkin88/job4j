package ru.job4j.collectionsort;

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
    @Override
    public int compareTo(User o) {
        return age.compareTo(o.getAge());
    }
}