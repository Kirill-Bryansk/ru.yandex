package ru.yandex.java_canban.model;

import ru.yandex.java_canban.model.Status;

public class Subtask extends Task {
    private final Integer epicId;

    public Subtask(String name, String description, Status status, Integer epicId) {
        super(name, description, status);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return  "ru.yandex.java_canban.model.Subtask (" +
                "Название: " + getName() +
                ", Описание: " + getDescription() +
                ", id=" + getId() +
                ", Статус: " + getStatus() +
                ", epicId=" + epicId + ")" + "\n";
    }
}
