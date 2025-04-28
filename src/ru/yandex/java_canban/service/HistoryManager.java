package ru.yandex.java_canban.service;

import ru.yandex.java_canban.model.Task;

import java.util.ArrayList;

public interface HistoryManager {
    void add(Task task);
    ArrayList<Task> getHistory();
    ArrayList<Task> getDefaultHistory(); // почему то static
}
