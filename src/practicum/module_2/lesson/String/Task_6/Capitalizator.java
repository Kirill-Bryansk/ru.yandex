package practicum.module_2.lesson.String.Task_6;

public class Capitalizator {
    public String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
