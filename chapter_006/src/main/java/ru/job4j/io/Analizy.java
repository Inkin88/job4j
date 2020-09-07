package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String startLine = null;
            List<String> list = new ArrayList<>();
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.startsWith("500") | line.startsWith("400") && startLine == null) {
                    startLine = line.substring(4);
                }
                if (line.startsWith("200") && startLine != null) {
                    list.add(startLine + ";" + line.substring(4) + System.lineSeparator());
                    startLine = null;
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(target));
            for(String str : list) {
                writer.write(str);
            }
            writer.close();
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

