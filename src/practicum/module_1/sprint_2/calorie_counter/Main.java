package practicum.module_1.sprint_2.calorie_counter;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu(); // вызвыли метод printMenu

            String command = scanner.next();
            switch (command.trim()) {
                case "1":
                    System.out.println();
                    System.out.println("Вы выбрали ввод количества шагов за день: ");
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case "2":
                    System.out.println();
                    stepTracker.changeStepGoal();
                    break;
                case "3":
                    System.out.println();
                    stepTracker.printStatistic();
                    break;
                case "4":
                    System.out.println();
                    System.out.println("Работа с приложением завершена. Ходить полезно!");
                    System.out.println("-".repeat(45)); // печатает при выходе из цикла while
                    return;
                default:
                    System.out.println();
                    System.out.println("Введена не коректная команда!");
                    break;
            }
        }
    }

    static void printMenu() {
        System.out.println();
        System.out.println("-".repeat(15) + "Перечень команд" + "-".repeat(15));
        System.out.println("1. Ввести количество шагов за определенный день.");
        System.out.println("2. Изменить цель по количеству шагов в день.");
        System.out.println("3. Напечатать статистику за определенный месяц.");
        System.out.println("4. Выйти из приложения.");
        System.out.println();
        System.out.print("Введите порядковый номер команды: ");
    }
}