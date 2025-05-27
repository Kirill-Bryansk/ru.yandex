package practicum.module_2.lesson.String.Task_5;

public class Practicum {
    public static void main(String[] args) {
        FindRepeats check = new FindRepeats();
        int count = check.numberOfRepeats("раз, раз, раз", "раз");
        System.out.println(count);
    }
}
