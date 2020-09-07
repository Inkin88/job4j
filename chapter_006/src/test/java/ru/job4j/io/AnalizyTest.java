package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class AnalizyTest {
    String tmp;


    @Before
    public void deleteFile() {
        tmp = System.getProperty("java.io.tmpdir");
        try (PrintWriter out = new PrintWriter(new FileOutputStream(tmp + "server.log"))) {
            out.println("200 10:56:01");
            out.println("");
            out.println("500 10:57:01");
            out.println("");
            out.println("400 10:58:01");
            out.println("");
            out.println("200 10:59:01");
            out.println("");
            out.println("500 11:01:02");
            out.println("");
            out.println("200 11:02:02");
            out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void deleteFileAfter() {
        File file = new File(tmp + "server.log");
        if (file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.delete();
        }
        file = new File(tmp + "target.csv");
        if (file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.delete();
        }
    }


    @Test
    public void unavailable() throws IOException {
        new Analizy().unavailable(tmp + "server.log", tmp + "target.csv");
        BufferedReader reader = new BufferedReader(new FileReader(tmp + "target.csv"));
        assertThat(reader.readLine(), is("10:57:01;10:59:01"));
        assertThat(reader.readLine(), is("11:01:02;11:02:02"));
    }
}