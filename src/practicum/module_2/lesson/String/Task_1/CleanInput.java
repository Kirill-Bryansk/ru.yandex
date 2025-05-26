package practicum.module_2.lesson.String.Task_1;

public class CleanInput {
    public String fixString(String str) {
        if (str.isBlank()){
            return "Вы ничего не ввели!";
        } else {
            return str.trim();
        }
    }
}