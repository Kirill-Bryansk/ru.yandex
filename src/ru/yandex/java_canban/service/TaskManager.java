package ru.yandex.java_canban.service;

import ru.yandex.java_canban.model.Epic;
import ru.yandex.java_canban.model.Status;
import ru.yandex.java_canban.model.Subtask;
import ru.yandex.java_canban.model.Task;

import java.util.ArrayList;

public interface TaskManager {
    int getCount();

    void addTask(Task task);

    void addEpic(Epic epic);

    void addSubtask(Subtask subtask);

    ArrayList<Task> getTaskMap();

    ArrayList<Epic> getEpicMap();

    ArrayList<Subtask> getSubtaskMap();

    void clearTask();

    void clearEpic();

    void clearSubtask();

    Task getTaskById(Integer id);

    Epic getEpicById(Integer id);

    Subtask getSubtaskById(Integer id);

    Task updateTask(Task task);

    Epic updateEpic(Epic epic);

    Subtask updateSubtask(Subtask subtask);

    void deleteTaskById(Integer id);

    void deleteEpicById(Integer id);

    void deleteSubtaskById(Integer id);

    ArrayList<Subtask> getSubtaskByEpic(Integer epicId);

    void updateEpicStatus(Epic epic);

    void changeStatus(Integer id, Status status);
}
