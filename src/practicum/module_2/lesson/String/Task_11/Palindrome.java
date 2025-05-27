package practicum.module_2.lesson.String.Task_11;

public class Palindrome {
    public boolean isPalindromeLine(String str) {
        StringBuilder builder = new StringBuilder(str.toLowerCase());
        int index = 0;

        while (index != -1) {
            index = builder.indexOf(" ", index);
            if (index != -1) {
                builder.deleteCharAt(index);
            }
        }
        StringBuilder reversed = new StringBuilder(builder);
        reversed.reverse();
        return builder.toString().equals(reversed.toString());
    }
}
