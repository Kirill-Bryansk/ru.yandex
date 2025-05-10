package practicum.module_1.sprint_2.lesson_Method.Task_5;

public class Practicum {

    public static void main(String[] args) {
        double[] expenses = {1772.5, 367.0, 120.6, 2150.2, 874.0, 1.0, 1459.4};
        double maxExpense = findMaxExpense(expenses); // вызовите метод и присвойте maxExpense значение его результата
        System.out.println("Самая большая трата недели " + maxExpense);
    }

    public static double findMaxExpense(double[] expenses) {// объявите метод findMaxExpense
        double maxExpense = -1; // реализуйте метод. Чтобы найти самую большую трату,  воспользуйтесь циклом
        for (int i = 0; i < expenses.length; i++){
            if (expenses[i] > maxExpense) {
                // самую большую трату запишите в переменную maxExpense
                maxExpense = expenses[i];
            }
        }
        return maxExpense;
    }
}
