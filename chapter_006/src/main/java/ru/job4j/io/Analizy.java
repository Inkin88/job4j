package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String startLine = null;
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.startsWith("500") | line.startsWith("400") && startLine == null) {
                    startLine = line.substring(4);
                }
                if (line.startsWith("200") && startLine != null) {
                    writer.write(startLine + ";" + line.substring(4) + "\n");
                    startLine = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
//            out.println("15:01:30;15:02:32");
//            out.println("15:10:30;23:12:32");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        new Analizy().unavailable("./chapter_006/data/log.txt", "./unavailable.csv");
    }
}

