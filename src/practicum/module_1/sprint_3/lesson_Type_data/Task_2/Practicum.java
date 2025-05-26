package practicum.module_1.sprint_3.lesson_Type_data.Task_2;

import java.util.Scanner;

public class Practicum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        String name = scanner.nextLine();
        PersonAccount user = new PersonAccount(name);

        System.out.println("Хотите открыть счёт в RUB?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        int command = scanner.nextInt();
        if (command == 1) {
            user.moneyRUB = 0.0;
        }

        System.out.println("Хотите открыть счёт в USD?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        command = scanner.nextInt();
        if (command == 1) {
            user.moneyUSD = 0.0;
        }

        System.out.println("Хотите открыть счёт в EUR?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        command = scanner.nextInt();
        if (command == 1) {
            user.moneyEUR = 0.0;
        }

        System.out.println("Поздравляем, аккаунт для пользователя " + user.name + " создан.");
        System.out.println("Открытые счета:");
        if (user.moneyRUB != null) {
            System.out.println("- RUB");
        }
        if (user.moneyUSD != null) {
            System.out.println("- USD");
        }
        if (user.moneyEUR != null) {
            System.out.println("- EUR");
        }

    }
}

class PersonAccount {
    String name;      // имя и фамилия
    Double moneyRUB;  // счёт в рублях
    Double moneyUSD;  // счёт в долларах
    Double moneyEUR;  // счёт в евро

    PersonAccount(String userName) {
        name = userName;
    }
}
