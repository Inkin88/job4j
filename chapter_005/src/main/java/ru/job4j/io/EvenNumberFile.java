package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder builder = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
               builder.append((char) read);
            }
            String[] lines = builder.toString().split(System.lineSeparator());
            for (String line : lines) {
                if (Integer.parseInt(line) % 2 == 0) {
                    System.out.println(line +" " + true);
                } else {
                    System.out.println(line +" " +false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
