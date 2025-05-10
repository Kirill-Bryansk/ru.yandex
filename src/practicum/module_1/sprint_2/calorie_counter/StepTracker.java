package practicum.module_1.sprint_2.calorie_counter;

import java.util.Scanner;

public class StepTracker {
    Scanner scanner; // поле с типом сканер
    Converter converter = new Converter();
    MonthData[] monthToData = new MonthData[12]; //
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) { // конструктор класса
        scanner = scan; // поле принимающее аргумент консольного ввода
        for (int i = 0; i < monthToData.length; i++) { // Цикл создает 12 экземпляров класса MonthData
            monthToData[i] = new MonthData(); // Присваиваем массиву из 12 месяцев по индексу значение 30 дней
        }
    }

    void changeStepGoal() {
        System.out.print("Введите новую норму количества шагов в день: ");
        goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay <= 0) {
            System.out.println("Некоректный ввод количества шагов!");
            return;
        }
        System.out.println("Сохранено! Новая норма: " + goalByStepsPerDay + " шагов в день.");
    }

    void addNewNumberStepsPerDay() {
        System.out.print("Ведите номер месяца: ");
        int monthNumber = scanner.nextInt();
        if (monthNumber <= 0) {
            System.out.println("Некоректный ввод месяца!");
            return;
        } else if (monthNumber > 12) {
            System.out.println("Некоректный ввод месяца!");
            return;
        }
        System.out.print("Введите номер дня в месяце: ");
        int daysNumber = scanner.nextInt();
        if (daysNumber <= 0) {
            System.out.println("Некоректный ввод дня!");
            return;
        } else if (daysNumber > 30) {
            System.out.println("Некоректный ввод дня!");
            return;
        }
        System.out.print("Введите количество пройденных шагов: ");
        int stepsPerDay = scanner.nextInt();
        if (stepsPerDay <= 0) {
            System.out.println("Некоректный ввод количества шагов!");
            return;
        }
        MonthData monthData = monthToData[monthNumber - 1];
        monthData.days[daysNumber - 1] = stepsPerDay;
        System.out.println("Результат сохранен!  " + daysNumber + " день. " + monthNumber + " месяца."
                + " Пройдено: " + stepsPerDay + " шагов");
    }

    void printStatistic() {
        System.out.print("Введите номер месяца для печати статистики: "); // ввод и проверка номера месяца
        int monthNumber = scanner.nextInt();
        if ((monthNumber > 12) || (monthNumber <= 0)) {
            System.out.println("Некоректный ввод месяца!");
        } else {
            MonthData monthData = monthToData[monthNumber - 1]; // получение соответствующего месяца
            int sumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц
            if (sumSteps == 0) {
                System.out.println("Данные за выбранный месяц отсутствуют!");
            } else {
                monthData.printDaysAndStepsFromMonth();    // вывод общей статистики по дням
                System.out.println("За месяц пройдено: " + sumSteps + " шагов.");    // вывод суммы шагов за месяц
                // вывод максимального пройденного количества шагов за месяц
                System.out.println("Максимальное пройденное количество шагов: " + monthData.maxSteps());
                // вывод среднего пройденного количества шагов за месяц
                System.out.println("Среднее количество шагов за месяц: " + monthData.averageValue());
                // вывод пройденной за месяц дистанции в километрах
                System.out.println("Пройденная за месяц дистанции в километрах: "
                        + converter.convertToKm(sumSteps));
                // вывод количества сожжённых килокалорий за месяц
                System.out.println("Калорий израсходовали: "
                        + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
                // вывод лучшей серии
                System.out.println("Вы выполняли или привышвли норму шагов " + monthData.bestSeries(goalByStepsPerDay)
                        + " дней(я) подряд за месяц");
                System.out.println();// дополнительный перенос строки
            }
        }
    }
}
