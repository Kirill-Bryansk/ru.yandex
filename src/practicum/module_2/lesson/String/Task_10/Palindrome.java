package practicum.module_2.lesson.String.Task_10;

public class Palindrome {
    public boolean isPalindromeWord(String str) {
        StringBuilder word = new StringBuilder(str);
        return str.equals(word.reverse().toString());
    }
}
