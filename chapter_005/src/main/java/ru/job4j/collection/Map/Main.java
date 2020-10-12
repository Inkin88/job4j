package ru.job4j.collection.Map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Airat", 2, new GregorianCalendar(1988, 4, 21));
        User user2 = new User("Airat", 2, new GregorianCalendar(1988, 4, 21));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, null);
        map.put(user2, null);
        System.out.println(map);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
