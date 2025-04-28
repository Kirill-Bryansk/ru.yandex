import ru.yandex.java_canban.model.Epic;
import ru.yandex.java_canban.model.Status;
import ru.yandex.java_canban.model.Subtask;
import ru.yandex.java_canban.model.Task;
import ru.yandex.java_canban.service.Manager;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        // Две задачи
        manager.addTask(new Task("Задача 1", "Выполнить 1 задачу", Status.NEW));
        manager.addTask(new Task("Задача 2", "Выполнить 2 задачу",Status.NEW));
        // Эпик с двумя подзадачами
        Epic epic1 = new Epic("Эпик 1", "Очень Важный");
        manager.addEpic(epic1);
        manager.addSubtask(new Subtask("Sub - Эпика 1", "Подзадача 1", Status.NEW, 3));
        manager.addSubtask(new Subtask("Sub - Эпика 1", "Подзадача 2", Status.NEW, 3));
        // Эпик с одной подзадачей
        Epic epic2 = new Epic("Эпик 1", "Не менее Важный");
        manager.addEpic(epic2);
        manager.addSubtask(new Subtask("Sub - Эпика 2", "Подзадача 1", Status.NEW, 6));
        // Печать списки Эпиков, Задач, Подзадач
        System.out.println(manager.getTaskMap());
        System.out.println(manager.getEpicMap());
        System.out.println(manager.getSubtaskMap());
        // Изменяю статус ru.yandex.java_canban.model.Task
        manager.changeStatus(1,Status.DONE);
        manager.changeStatus(2,Status.IN_PROGRESS);
        // Изменяю статус SubTask
        manager.changeStatus(4,Status.DONE);
        manager.changeStatus(5, Status.DONE);
        manager.changeStatus(7, Status.IN_PROGRESS);
        // Расчитываю статус ru.yandex.java_canban.model.Epic
        manager.updateEpicStatus(epic1);
        manager.updateEpicStatus(epic2);
        // Печатаю после изменений
        System.out.println(manager.getTaskById(1));
        System.out.println(manager.getTaskById(2));
        System.out.println(manager.getSubtaskById(4));
        System.out.println(manager.getSubtaskById(5));
        System.out.println(manager.getSubtaskById(7));
        System.out.println(manager.getEpicById(3));
        System.out.println(manager.getEpicById(6));
    }
}