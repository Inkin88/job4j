package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     return persons.stream().filter(person -> person.getAdress().contains(key) || person.getName().contains(key) || person.getPhone().contains(key) || person.getSurname().contains(key)).collect(Collectors.toList());

    }
}
