package java_canban.service;

import java_canban.model.Task;
import java.util.List;

public interface HistoryManager {

    List<Task> getHistory();

    void add(Task task);
}
