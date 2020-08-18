package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class AnalizyTest {
    String source = "C:\\projects\\job4j\\chapter_006\\data\\log.txt";
    String target = "C:\\projects\\job4j\\unavailable.csv";
    File file = new File(target);

    @Before
    public void deleteFile() {
        if (file.delete()) {
            System.out.println("File is deleted");
        }
    }

    @After
    public void deleteFileAfter() {
        if (file.delete()) {
            System.out.println("File is deleted");
        }
    }


    @Test
    public void unavailable() throws IOException {
        new Analizy().unavailable(source, target);
        BufferedReader reader = new BufferedReader(new FileReader(target));
        assertThat(reader.readLine(), is("10:57:01;10:59:01"));
        assertThat(reader.readLine(), is("11:01:02;11:02:02"));
    }
}