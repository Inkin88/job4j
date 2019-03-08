package ru.job4j.tracker;

public class StubInput implements Input {
    private final String[] answers;
    private int position = 0;
    public StubInput(final String[] answers) {
        this.answers = answers;
    }
    @Override
    public String ask(String question) {
        return this.answers[this.position++];
    }
    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}
