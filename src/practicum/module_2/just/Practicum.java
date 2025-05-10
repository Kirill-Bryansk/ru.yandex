package practicum.module_2.just;

public class Practicum {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 4 ,1 ,2};
        int sum = 0;
        for (int number1 : array) {
            for (int number2: array) {
                sum += number1 * number2;
            }
        }
    }
}
