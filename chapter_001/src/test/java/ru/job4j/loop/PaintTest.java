package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;

import java.util.StringJoiner;

import static org.junit.Assert.*;

public class PaintTest {
    @Test
    public void whenPeramid4Right() {
        Paint paint = new Paint();
        String rst = paint.rightTrl(4);
        System.out.println(rst);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("^   ")
                .add("^^  ")
                .add("^^^ ")
                .add("^^^^")
                .toString()
        ));
    }

    @Test
    public void whenPeramid4Left() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(4);
        System.out.println(rst);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("   ^")
                .add("  ^^")
                .add(" ^^^")
                .add("^^^^")
                .toString()));
    }

    @Test
    public void whenPeramud() {
        Paint paint = new Paint();
        String rst = paint.pyramid(4);
        System.out.println(rst);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("   ^   ")
                .add("  ^^^  ")
                .add(" ^^^^^ ")
                .add("^^^^^^^")
                .toString()));
    }
}