package ru.yandex.java_canban.service;

import ru.yandex.java_canban.model.Task;

import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager {

    @Override
    public void add(Task task) {

    }

    @Override
    public ArrayList<Task> getHistory() {
        return null;
    }

    @Override
    public ArrayList<Task> getDefaultHistory() {
        return null;
    }
}
