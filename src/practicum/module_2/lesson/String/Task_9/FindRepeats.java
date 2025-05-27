package practicum.module_2.lesson.String.Task_9;

public class FindRepeats {
    int numberOfRepeats(String text, String substring) {
        StringBuilder sb = new StringBuilder(text);
        int counter = 0;
        int index = sb.indexOf(substring);
        while (index != -1) {
            counter++;
            int cuttingIndex = index + substring.length();
            sb.delete(0, cuttingIndex);
            index = sb.indexOf(substring);
        }
        return counter;
    }
}
