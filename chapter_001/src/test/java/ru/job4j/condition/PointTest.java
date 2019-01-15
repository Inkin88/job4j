package ru.job4j.condition;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
public class PointTest  {
    @Test
    public void distanceFromPointAToB() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double result = a.distanceTo(b);
        double expected = 4.47213595499958;
        assertThat(result, closeTo(expected, 0.1));
    }
}