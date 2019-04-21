package ru.job4j.collectionsort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Airat Muzafarov
 * @since 25/03/2019
 * @version 0.1
 */

public class SortUser {
    /**
     * sorted users by age.
     * @param users List
     * @return sorted set
     */

    public Set<User> sort(List<User> users) {

        return new TreeSet<>(users);
    }

    /**
     * Метод сортирует входящий список по длине имени юзера.
     * @param user юзер
     * @return отсортированный список по длине имени.
     */
    public List<User> sortNameLength(List<User> user) {
        Comparator<User> sortName = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
               return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        };
        return user.stream().sorted(sortName).collect(Collectors.toList());
    }

    /**
     * Метод сортирует сначала по имени, затем по возрасту.
     * @param user юзер
     * @return отсортированный список.
     */
    public List<User> sortByAllFields(List<User> user) {
        Comparator<User> sortFields = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int rs = o1.getName().compareTo(o2.getName());
                return rs == 0 ? Integer.compare(o1.getAge(), o2.getAge()) : rs;
            }
        };
        return user.stream().sorted(sortFields).collect(Collectors.toList());
    }
}