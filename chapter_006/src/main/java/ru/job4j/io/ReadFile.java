package ru.job4j.io;

import java.io.FileInputStream;

/**
 * @author Airat Muzafarov.
 * @version 0.1
 * @since 13/08/2020
 */

public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
