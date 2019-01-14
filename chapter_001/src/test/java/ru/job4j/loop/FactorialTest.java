package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Factorial.
 *@author Airat Muzafarov (inkin_88@mail.ru)
 *@version $Id$
 *@since 0.1
 */
public class FactorialTest {
    /**
     * Факториал для числа 5, должен быть 120.
     */
    @Test
    public void factorialOfNumberFiveIsOneHundredTwenty() {
        Factorial fact = new Factorial();
        int result = fact.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Факториал для чесла 0 равен 1.
     */
    @Test
    public void factorialOfNumberZeroIsOne() {
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        assertThat(result, is(1));
    }
}