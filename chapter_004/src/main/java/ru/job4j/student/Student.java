package ru.job4j.student;

public class Student {

    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }
    public Student() {

    }
    public String getName() {
        return name;
    }
    public int getScope() {
        return scope;
    }
}
