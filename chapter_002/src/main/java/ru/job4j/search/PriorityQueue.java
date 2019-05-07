package ru.job4j.search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    public void put(Task task) {
        Iterator<Task> iter = tasks.iterator();
        List<Task> gg = tasks.stream().filter(task1 -> iter.next().getPriority() < task.getPriority()).collect(Collectors.toList());
       /* int i = 0;
        for (; iter.hasNext(); i++) {
            if (iter.next().getPriority() > task.getPriority()) {
                break;
            }
        }*/
        tasks.add(gg.size(), task);
    }
    public Task take() {
        return this.tasks.poll();
    }
}
