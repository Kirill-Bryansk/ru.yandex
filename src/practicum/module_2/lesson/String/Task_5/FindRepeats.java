package practicum.module_2.lesson.String.Task_5;

public class FindRepeats {
    int numberOfRepeats(String text, String substring) {
        int count = 0;
        while (text.contains(substring))
        {
            count++;
            text = text.substring(text.indexOf(substring) + substring.length());
        }
        return count;
    }
}