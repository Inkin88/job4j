package ru.job4j.department;

import java.util.*;

/**
 * @author Airat Muzafarov.
 * @since 12/05/19
 * @version 0.1.
 */
public class Department {
        TreeSet<String> sort(List<String> dept, Comparator<String> comparator) {
        TreeSet<String> sortedList = new TreeSet<>(comparator);
        Set<String> changedList = check(dept);
        sortedList.addAll(changedList);
        return sortedList;
    }

    /**
     * Сортирует список в алфавитном порядке.
     * @param dept структура предприятия.
     * @return отсортированный список.
     */
    public TreeSet<String> naturalSort(List<String> dept) {
        return sort(dept, Comparator.naturalOrder());
    }

    /**
     * Сортирует список в обратном порядке.
     * @param dept структура предприятия.
     * @return отсортированный список.
     */
    public TreeSet<String> reverseSort(List<String> dept) {
        return sort(dept, new DeptComparator());
    }

    /**
     * Метод преобразует список структуры предприятия, добавляет недостающие отделы и подразделения.
     * @param dept структура предприятия
     * @return новый список.
     */
    private Set<String> check(List<String> dept) {
        Set<String> result = new HashSet<>(dept);
        for (String d : dept) {
            int temp = d.indexOf('\\');
            if (temp == -1) {
                result.add(d);
            }
            while (temp != -1) {
                result.add(d.substring(0, temp));
                temp = d.indexOf('\\', temp + 1);
            }

        }
        return result;
    }
}
