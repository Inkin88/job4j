package ru.job4j.coffeemachine;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class CoffeemachineTest {
    @Test
    public void changeFrom100() {
        Coffeemachine machine = new Coffeemachine();
        int[] expect = {10, 10, 10, 10, 10, 10, 5};
        int[] result = machine.changes(100, 35);
        assertThat(result, is(expect));
    }
}
