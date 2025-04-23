import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Manager { // здесь должен быть поле - счетчик
    private final HashMap<Integer, Task> taskMap = new HashMap<>();
    private final HashMap<Integer, Epic> epicMap = new HashMap<>();
    private final HashMap<Integer, Subtask> subtaskMap = new HashMap<>();

    private int count = 1;

    public int getCount() {
        return count++;
    }

    public void addTask(Task task) {
        task.setId(getCount());
        taskMap.put(task.getId(), task);
    }

    public void addEpic(Epic epic) {
        epic.setId(getCount());
        epicMap.put(epic.getId(), epic);
    }

    public void addSubtask(Subtask subtask) {
        subtask.setId(getCount()); // Получили id и передали его во входяший subtask
        subtaskMap.put(subtask.getId(), subtask);
        Collection<Integer> collection = epicMap.keySet(); // получили все ключи из epicMap
        for (Integer key : collection) { // перебираем все ключи
            if (key.equals(subtask.getEpicId())) { // если ключ подходит к idEpica
                Epic epic = epicMap.get(key); // получаем этот эпик
                epic.addSubtaskList(subtask); // добавляем subtack в эпик
                updateEpicStatus(epic);
                epicMap.put(key, epic); // сохраняем эпик с субтаском
            }
        }
    }

    public HashMap<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public HashMap<Integer, Epic> getEpicMap() {
        return epicMap;
    }

    public HashMap<Integer, Subtask> getSubtaskMap() {
        return subtaskMap;
    }

    public void cleaTask() {
        taskMap.clear();
    }

    public void cleaEpic() {
        taskMap.clear();
    }

    public void clearSubtask() {
        subtaskMap.clear();
    }

    public Task getTaskById(Integer id) {
        return taskMap.get(id);
    }

    public Epic getEpicById(Integer id) {
        return epicMap.get(id);
    }

    public Subtask getSubtaskById(Integer id) {
        return subtaskMap.get(id);
    }

    public Task updateTask(Task task) {
        Integer taskID = task.getId();
        if (taskID == null || !taskMap.containsKey(taskID)) {
            return null;
        }
        taskMap.replace(taskID, task);
        return task;
    }

    public Epic updateEpic(Epic epic) { // надо проверить
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

    public Subtask updateSubtask(Subtask subtask) {
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

    public void deleteTaskById(Integer id) {
        taskMap.remove(id);
    }

    public void deleteEpicById(Integer id) {
        ArrayList<Subtask> epicSubtasks = epicMap.get(id).getSubtaskList();
        epicMap.remove(id);
        for (Subtask subtask : epicSubtasks) {
            subtaskMap.remove(subtask.getId()); // удаляем субтаски эпика
        }
    }

    public void deleteSubtaskById(Integer id) {
        Subtask subtask = subtaskMap.get(id);
        Integer epicId = subtask.getEpicId();
        subtaskMap.remove(id);
        Epic epic = epicMap.get(epicId);
        ArrayList<Subtask> newSubtaskList = epic.getSubtaskList();
        newSubtaskList.remove(subtask);
        epic.setSubtaskList(newSubtaskList);
        updateEpicStatus(epic);
    }

    public ArrayList<Subtask> getSubtaskByEpic(Integer epicId) {
        ArrayList<Subtask> subtaskList = new ArrayList<>();
        Collection<Integer> collection = epicMap.keySet(); // получили все ключи из epicMap
        for (Integer key : collection) { // перебираем все ключи
            if (key.equals(epicId)) { // если ключ подходит к idEpica
                Epic epic = epicMap.get(key); // получаем этот эпик
                subtaskList = epic.getSubtaskList();
            }
        }
        if (subtaskList.isEmpty()) {
            return null;
        } else {
            return subtaskList;
        }
    }

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

    public void changeStatus(Integer id, Status status) {
        Collection<Integer> collectionTask = taskMap.keySet(); // получили все ключи из epicMap
        for (Integer key : collectionTask) { // перебираем все ключи
            if (key.equals(id)) {
                Task task = taskMap.get(key);
                task.setStatus(status);
                taskMap.put(key, task);
            }
        }
        Collection<Integer> collectionSubtask = subtaskMap.keySet();
        for (Integer key : collectionSubtask) { // перебираем все ключи
            if (key.equals(id)) {
                Subtask subtask = subtaskMap.get(key);
                subtask.setStatus(status);
                taskMap.put(key, subtask);
            }
        }
    }
}