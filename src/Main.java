import ru.yandex.java_canban.model.*;
import ru.yandex.java_canban.service.InMemoryHistoryManager;
import ru.yandex.java_canban.service.InMemoryTaskManager;
import ru.yandex.java_canban.service.Managers;
//import ru.yandex.java_canban.service.Managers;

public class Main {

    public static void main(String[] args) {
        InMemoryTaskManager managers = Managers.getDefault(); //Managers.getDefaultHistory()
        // Две задачи
        managers.addTask(new Task("Задача 1", "Выполнить 1 задачу"));
        managers.addTask(new Task("Задача 2", "Выполнить 2 задачу"));
        // Эпик с двумя подзадачами
        Epic epic1 = new Epic("Эпик 1", "Очень Важный");
        managers.addEpic(epic1);
        managers.addSubtask(new Subtask("Sub - Эпика 1", "Подзадача 1", 3));
        managers.addSubtask(new Subtask("Sub - Эпика 1", "Подзадача 2",  3));
        // Эпик с одной подзадачей
        Epic epic2 = new Epic("Эпик 2", "Не менее Важный");
        managers.addEpic(epic2);
        managers.addSubtask(new Subtask("Sub - Эпика 2", "Подзадача 1",  6));
        // Печать списки Эпиков, Задач, Подзадач
        System.out.println(managers.getTaskMap());
        System.out.println(managers.getEpicMap());
        System.out.println(managers.getSubtaskMap());
        // Изменяю статус ru.yandex.java_canban.model.Task
        managers.changeStatus(1,Status.DONE);
        managers.changeStatus(2,Status.IN_PROGRESS);
        // Изменяю статус SubTask
        managers.changeStatus(4,Status.DONE);
        managers.changeStatus(5, Status.DONE);
        managers.changeStatus(7, Status.IN_PROGRESS);

        System.out.println("---------");
        managers.updateSubtask(managers.getSubtaskById(10));
        System.out.println("---------");
        // Расчитываю статус ru.yandex.java_canban.model.Epic
        managers.updateEpicStatus(epic1);
        managers.updateEpicStatus(epic2);
        // Печатаю после изменений
        System.out.println(managers.getTaskById(1));
        System.out.println(managers.getTaskById(2));
        System.out.println(managers.getSubtaskById(4));
        System.out.println(managers.getSubtaskById(5));
        System.out.println(managers.getSubtaskById(7));
        System.out.println(managers.getEpicById(3));
        System.out.println(managers.getEpicById(6));

        System.out.println("-".repeat(10));
        System.out.println(managers.getHistory());
    }
}