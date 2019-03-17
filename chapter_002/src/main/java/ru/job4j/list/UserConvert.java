package ru.job4j.list;
import java.util.HashMap;
import java.util.List;

/**
 * @author Airat Muzafarov.
 * @since 17.03.2019.
 * @version 0.1
 */

public class UserConvert {
    /**
     * Метод конвертирует лист Юзеров, в HashMap.
     * @param list Юзеров
     * @return HashMap
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userdata = new HashMap<>();
        for (User user : list) {
            userdata.put(user.getUserId(), user);
        }
        return userdata;
    }
}
