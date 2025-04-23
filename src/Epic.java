import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtaskList = new ArrayList<>();

    public Epic(String name, String description, Status status) {
        super(name, description, status);
    }

    public void addSubtaskList(Subtask subtask) { // добавляем строки субтаска в Epic
        subtaskList.add(subtask);
    }

    public ArrayList<Subtask> getSubtaskList() {
        return subtaskList;
    }

    public void setSubtaskList(ArrayList<Subtask> subtaskList) {
        this.subtaskList = subtaskList;
    }

    @Override
    public String toString() {
        return " Epic: " +
                " Название: " + getName() +
                ", Описание: " + getDescription() +
                ", Id = " + getId() +
                ", Статус: " + getStatus() +
                ", Subtask: " + subtaskList +
                "\n";
    }
}
