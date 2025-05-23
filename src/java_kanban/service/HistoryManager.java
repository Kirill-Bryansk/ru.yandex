package java_kanban.service;

import java_kanban.service.model.Task;

import java.util.List;

public interface HistoryManager {

    List<Task> getHistory();

    void add(Task task);

    void remove(int id);
}
