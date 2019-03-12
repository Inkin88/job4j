package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Airat Muzafarov.
 * @version 0.1.
 * @since 12.03.2019
 */

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод осущетвляющий поиск по заданному значению во всех полях класса Person.
     * @param key символы по которым мы будем искать.
     * @return список найденных персон.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person p : persons) {
            if (p.getAdress().contains(key) || p.getName().contains(key) || p.getPhone().contains(key) || p.getSurname().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }
}
