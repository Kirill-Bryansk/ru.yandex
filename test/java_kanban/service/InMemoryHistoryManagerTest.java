package java_kanban.service;

import java_kanban.model.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java_kanban.model.Epic;
import java_kanban.model.Subtask;
import java_kanban.model.Task;

import java.util.List;

public class InMemoryHistoryManagerTest {
    private HistoryManager historyManager;
    private TaskManager taskManager;

    @BeforeEach
    void init() {
        historyManager = Managers.getDefaultHistory();
        taskManager = Managers.getDefault();
    }

    @Test
    void shouldAddTasksAtHistoryList() {
        Task task = new Task("Задача 1", "Делать", 1, Status.NEW);

        historyManager.add(task);
        final List<Task> history = historyManager.getHistory();

        Assertions.assertNotNull(history, "История не пуста");
        Assertions.assertEquals(1, history.size(), "История не пуста");
    }

    @Test
    void shouldAddNewTaskAtTheEndOfHistoryList() {

        Task taskOne = new Task("Задача 1", "Делать", 1, Status.NEW);
        Task taskTwo = new Task("Задача 2", "Делать", 2, Status.NEW);

        historyManager.add(taskOne);
        historyManager.add(taskTwo);
        final List<Task> history = historyManager.getHistory();

        Assertions.assertEquals(taskTwo, history.get(history.size() - 1), "Задача является последней в истории");
    }

    @Test
    void shouldAddTheSameTaskJustOneTimeAtHistoryList() {
        // prepare
        Task taskOne = new Task("Задача", "Делать", 1, Status.NEW);

        // do
        historyManager.add(taskOne);
        historyManager.add(taskOne);
        historyManager.add(taskOne);
        final List<Task> history = historyManager.getHistory();

        // check
        Assertions.assertEquals(1, history.size(), "Задача не была продублирована в истории");
    }

    @Test
    void whenTaskHasDeletedShouldDeleteItFromHistoryList() {
        // prepare
        Task taskOne = new Task("Задача", "Делать", 1, Status.NEW);
        taskManager.addTask(taskOne);
        taskManager.getTaskById(taskOne.getId());

        // do
        taskManager.deleteTaskById(taskOne.getId());
        final List<Task> history = historyManager.getHistory();

        // check
        Assertions.assertEquals(0, history.size(), "Задача не удалена");
    }
}
