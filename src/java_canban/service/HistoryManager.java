package java_canban.service;

import java_canban.service.model.Task;

import java.util.List;

public interface HistoryManager {

    List<Task> getHistory();

    void add(Task task);
    void remove(int id);
}
