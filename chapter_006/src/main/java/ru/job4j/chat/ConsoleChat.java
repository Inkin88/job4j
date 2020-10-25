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
    private final List<String> log = new ArrayList<>();
    private final Random random = new Random();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        List<String> answers = getAnswersList();
        try (Scanner scanner = new Scanner(System.in)) {
            String s = "";
            while (!s.equals(OUT)) {
                s = scanner.nextLine();
                if (s.equals(STOP) || s.equals(OUT)) {
                    isNotStopped = false;
                } else if (s.equals(CONTINUE)) {
                    isNotStopped = true;
                }
                log.add(s);
                if (isNotStopped) {
                    log.add(getBotAnswer(answers));
                }
            }
        }
        writeToLog(log);
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(".\\chapter_006\\src\\main\\java\\ru\\job4j\\chat\\chatLog.txt",
                ".\\chapter_006\\src\\main\\java\\ru\\job4j\\chat\\answers.txt");
        try {
            cc.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getAnswersList() throws IOException {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            String s;
            while ((s = reader.readLine()) != null) {
                answers.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private String getBotAnswer(List<String> list) {
        String botAnswer = list.get(random.nextInt(list.size()));
        System.out.println(botAnswer);
        return botAnswer;
    }

    private void writeToLog(List<String> chat) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String s : chat) {
                writer.write(s + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
