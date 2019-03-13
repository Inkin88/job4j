package ru.job4j.search;

import java.util.Iterator;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    public void put(Task task) {
        Iterator<Task> iter = tasks.iterator();
        int i = 0;
        for (; iter.hasNext(); i++) {
            if (iter.next().getPriority() > task.getPriority()) {
                break;
            }
        }
        tasks.add(i, task);

    }
    public Task take() {
        return this.tasks.poll();
    }
}
