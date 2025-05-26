package practicum.module_1.sprint_2.lesson_Method.Task_1;

import java.util.Scanner;
public class Practicum {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    }
    public static void welcomeUserByName() {
        System.out.println("Как вас зовут?");
        String name = scanner.next();
        System.out.println("Рад познакомиться, " + name + "!");
    }
    public static void printSuccess() {
        System.out.println("У вас уже неплохо получается программировать!");
    }
    public static void sayHelloByTime() {
        System.out.println("Который час?");
        int currentHour = scanner.nextInt();
        if (currentHour < 6) {
            System.out.println("Доброй ночи!");
        } else if (currentHour >= 22) {
            System.out.println("Доброй ночи!");
        } else if (currentHour < 12) {
            System.out.println("Доброе утро!");
        } else if (currentHour < 18) {
            System.out.println("Добрый день!");
        } else {
            System.out.println("Добрый вечер!");
        }
    }
}
