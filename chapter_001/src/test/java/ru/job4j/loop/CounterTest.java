package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тест к классу Counter.
 *@author Airat Muzafarov (inkin_88@mail.ru)
 *@version $Id$
 *@since 0.1
 */
public class CounterTest {
    /**
     * Задаем диапазон от 1 до 10, сумма должна получится 30.
     */
    @Test
    public void sumOfEvenNumbersThenThirty() {
        Counter counter = new Counter();
       int result = counter.add(1, 10);
       assertThat(result, is(30));
    }
}

