package practicum.module_1.sprint_3.dinner_constructor;

import java.util.Scanner;

public class Main {
    static DinnerConstructor dc;
    static Scanner scanner;
    static MenuDishes md;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        md = new MenuDishes();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Некорректный вввод!");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        md.saveDishMenu(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода " +
                "введите пустую строку");
        while (true) {
            String nextItem = scanner.nextLine();
            if (!nextItem.isEmpty() && md.menu.containsKey(nextItem)) {
                md.chosenTypes.add(nextItem);
                System.out.println(md.chosenTypes);
            } else if (nextItem.equals("") && md.chosenTypes.isEmpty()) {
                System.out.println("Вы завершили ввод.");
                return;
            } else if (!nextItem.isEmpty()) {
                System.out.println("Такой тип блюда не найден!");
                System.out.println("Для выхода нажмите Enter.");
                System.out.println("Повторите ввод:");
                continue;
            } else if (nextItem.equals("") & !md.chosenTypes.isEmpty()) {
                dc.printCombos(numberOfCombos, md);
                break;
            }
        }
    }
}


