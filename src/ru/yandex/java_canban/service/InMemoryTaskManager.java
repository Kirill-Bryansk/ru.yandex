package ru.yandex.java_canban.service;

import ru.yandex.java_canban.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class InMemoryTaskManager implements TaskManager {

    private final HashMap<Integer, Task> taskMap = new HashMap<>();
    private final HashMap<Integer, Epic> epicMap = new HashMap<>();
    private final HashMap<Integer, Subtask> subtaskMap = new HashMap<>();
    private int count = 1;

    @Override
    public int getCount() {
        return count++;
    }

    @Override
    public void addTask(Task task) {
        task.setId(getCount());
        task.setStatus(Status.NEW);
        taskMap.put(task.getId(), task);
    }

    @Override
    public void addEpic(Epic epic) {
        epic.setId(getCount());
        epic.setStatus(Status.NEW);
        epicMap.put(epic.getId(), epic);
    }

    @Override
    public void addSubtask(Subtask subtask) {
        subtask.setId(getCount());
        subtask.setStatus(Status.NEW);
        subtaskMap.put(subtask.getId(), subtask);
        epicMap.get(subtask.getEpicId()).addSubtaskList(subtask);
        Epic epic = epicMap.get(subtask.getEpicId());
        updateEpicStatus(epic);
    }

    @Override
    public ArrayList<Task> getTaskMap() {
        return new ArrayList<>(taskMap.values());
    }

    @Override
    public ArrayList<Epic> getEpicMap() {
        return new ArrayList<>(epicMap.values());
    }

    @Override
    public ArrayList<Subtask> getSubtaskMap() {
        return new ArrayList<>(subtaskMap.values());
    }

    @Override
    public void clearTask() {
        taskMap.clear();
    }

    @Override
    public void clearEpic() {
        taskMap.clear();
        subtaskMap.clear();
    }

    @Override
    public void clearSubtask() {
        subtaskMap.clear();
        for (Epic epic : epicMap.values()) {
            epic.clearSubtaskList();
            epic.setStatus(Status.NEW);
        }
    }

    @Override
    public Task getTaskById(Integer id) {
        return taskMap.get(id);
    }

    @Override
    public Epic getEpicById(Integer id) {
        return epicMap.get(id);
    }

    @Override
    public Subtask getSubtaskById(Integer id) {
        return subtaskMap.get(id);
    }

    @Override
    public Task updateTask(Task task) {
        if (task != null) {
            Integer taskID = task.getId();
            if (taskID == null || !taskMap.containsKey(taskID)) {
                return null;
            }
            taskMap.replace(taskID, task);
            return task;
        }
        System.out.println("This task not exist");
        return null;
    }

    @Override
    public Epic updateEpic(Epic epic) { // надо проверить
        if (epic != null) {
            Integer epicId = epic.getId();
            if (epicId == null || !epicMap.containsKey(epicId)) {
                return null;
            }
            Epic existentEpic = epicMap.get(epicId);
            ArrayList<Subtask> existentEpicSubtaskList = existentEpic.getSubtaskList();
            if (!existentEpicSubtaskList.isEmpty()) {
                for (Subtask subtask : existentEpicSubtaskList) {
                    subtaskMap.remove(subtask.getId());
                }
            }
            epicMap.replace(epicId, epic); // замена эпика
            ArrayList<Subtask> newEpicSubtaskList = epic.getSubtaskList();
            if (!newEpicSubtaskList.isEmpty()) {
                for (Subtask subtask : newEpicSubtaskList) {
                    subtaskMap.put(subtask.getId(), subtask);
                }
            }
            updateEpicStatus(epic);
            return epic;
        }
        System.out.println("This epic not exist");
        return null;
    }

    @Override
    public Subtask updateSubtask(Subtask subtask) {
        if (subtask != null) {
            Integer subtaskId = subtask.getId();
            if (subtaskId == null || !subtaskMap.containsKey(subtaskId)) {
                return null;
            }
            Integer epicId = subtask.getEpicId();
            Subtask existentSubtask = subtaskMap.get(subtaskId);
            subtaskMap.replace(subtaskId, subtask);
            Epic epic = epicMap.get(epicId);
            ArrayList<Subtask> subtaskList = epic.getSubtaskList();
            subtaskList.remove(existentSubtask);
            subtaskList.add(subtask);
            epic.setSubtaskList(subtaskList);
            updateEpicStatus(epic);
            return subtask;
        }
        System.out.println("This subtask not exist");
        return null;
    }

    @Override
    public void deleteTaskById(Integer id) {
        if (id != null) {
            taskMap.remove(id);
        }
    }

    @Override
    public void deleteEpicById(Integer id) {
        if (id != null) {
            ArrayList<Subtask> epicSubtasks = epicMap.get(id).getSubtaskList();
            epicMap.remove(id);
            for (Subtask subtask : epicSubtasks) {
                subtaskMap.remove(subtask.getId());
            }
        }
    }

    @Override
    public void deleteSubtaskById(Integer id) {
        if (id != null) {
            Subtask subtask = subtaskMap.get(id);
            Integer epicId = subtask.getEpicId();
            subtaskMap.remove(id);
            Epic epic = epicMap.get(epicId);
            ArrayList<Subtask> newSubtaskList = epic.getSubtaskList();
            newSubtaskList.remove(subtask);
            epic.setSubtaskList(newSubtaskList);
            updateEpicStatus(epic);
        }
    }

    @Override
    public ArrayList<Subtask> getSubtaskByEpic(Integer epicId) {
        Epic epic = getEpicById(epicId);
        return new ArrayList<>(epic.getSubtaskList());
    }

    @Override
    public void updateEpicStatus(Epic epic) {
        int countDoneStatus = 0;
        int countNewStatus = 0;
        Collection<Subtask> list = epic.getSubtaskList();
        for (Subtask subtask : list) {
            if (subtask.getStatus() == Status.DONE) {
                countDoneStatus++;
            }
            if (subtask.getStatus() == Status.NEW) {
                countNewStatus++;
            }
        }
        if (countDoneStatus == list.size()) {
            epic.setStatus(Status.DONE);
        } else if (countNewStatus == list.size()) {
            epic.setStatus(Status.NEW);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }

    @Override
    public void changeStatus(Integer id, Status status) {
        Collection<Integer> collectionTask = taskMap.keySet();
        for (Integer key : collectionTask) {
            if (key.equals(id)) {
                Task task = taskMap.get(key);
                task.setStatus(status);
                taskMap.put(key, task);
            }
        }
        Collection<Integer> collectionSubtask = subtaskMap.keySet();
        for (Integer key : collectionSubtask) {
            if (key.equals(id)) {
                Subtask subtask = subtaskMap.get(key);
                subtask.setStatus(status);
                taskMap.put(key, subtask);
            }
        }
    }
}
