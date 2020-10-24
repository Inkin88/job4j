package ru.job4j.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static boolean isNotStopped = true;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path));
             Scanner scanner = new Scanner(System.in)) {
            String s = "";
            while (!s.equals(OUT)) {
                s = scanner.nextLine();
                if (s.equals(STOP) || s.equals(OUT)) {
                    isNotStopped = false;
                } else if (s.equals(CONTINUE)) {
                    isNotStopped = true;
                }
                writer.write(s + '\n');
                if (isNotStopped) {
                    writer.write(getBotAnswers() + '\n');
                }
            }
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("C:\\projects\\job4j\\chapter_006\\src\\main\\java\\ru\\job4j\\chat\\chatLog.txt",
                "C:\\projects\\job4j\\chapter_006\\src\\main\\java\\ru\\job4j\\chat\\answers.txt");
        try {
            cc.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getBotAnswers() throws IOException {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            String s;
            while ((s = reader.readLine()) != null) {
                answers.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        String result = answers.get(random.nextInt(answers.size()));
        System.out.println(result);
        return result;
    }
}
