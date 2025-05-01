package ru.yandex.java_canban.service;

import ru.yandex.java_canban.model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private final List<Task> historyList = new ArrayList<>(); // пишет вызваные задачи

    @Override
    public List<Task> getHistory() {
        if (!historyList.isEmpty()) {
            return historyList;
        } else {
            System.out.println("History is empty");
            return null;
        }
    }

    @Override
    public void add(Task task) {
        if (historyList.size() == 10) {
            historyList.remove(0); // удаляем первый
            historyList.add(task);
        } else {
            historyList.add(task);
        }
    }
}