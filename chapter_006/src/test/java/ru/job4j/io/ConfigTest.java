package ru.job4j.io;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/some_props_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name2"),
                is("Airat")
        );
        assertThat(config.value("age"), is("32"));
    }
}