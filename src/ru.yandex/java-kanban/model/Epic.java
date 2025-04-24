package model;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtaskList = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    public void addSubtaskList(Subtask subtask) { // добавляем строки субтаска в model.Epic
        subtaskList.add(subtask);
    }

    public ArrayList<Subtask> getSubtaskList() {
        return subtaskList;
    }

    public void setSubtaskList(ArrayList<Subtask> subtaskList) {
        this.subtaskList = subtaskList;
    }

    public void clearSubtaskList() {
        subtaskList.clear();
    }

    @Override
    public String toString() {
        return " model.Epic: " +
                " Название: " + getName() +
                ", Описание: " + getDescription() +
                ", Id = " + getId() +
                ", Статус: " + getStatus() +
                ", model.Subtask: " + subtaskList +
                "\n";
    }
}
