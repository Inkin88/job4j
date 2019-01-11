package ru.job4j.condition;

/**
 * @author Airat Muzafarov.
 * @version $Id$.
 * @since 0.1
 */
public class DummyBot {
    /**
     * Отвечает на вопросы
     * @param question отвечает на вопросы.
     * @return Ответ.
     */
    public String answer(String question) {
        String rs1 = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rs1 = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rs1 = "До скорой встречи.";
        }
        return rs1;
    }

}
