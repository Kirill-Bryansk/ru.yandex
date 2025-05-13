package java_canban.service;

import java_canban.model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private final List<Task> historyList = new ArrayList<>();
    private static final int NUMBER_OF_VIEWS = 10;

    @Override
    public void add(Task task) {
        if (historyList.size() == NUMBER_OF_VIEWS) {
            historyList.remove(0);
            historyList.add(task);
        } else {
            historyList.add(task);
        }
    }

    @Override
    public List<Task> getHistory() {
        if (!historyList.isEmpty()) {
            return List.copyOf(historyList);
        } else {
            System.out.println("History is empty");
            List<Task> emptyList = new ArrayList<>();
            return emptyList;
        }
    }
}