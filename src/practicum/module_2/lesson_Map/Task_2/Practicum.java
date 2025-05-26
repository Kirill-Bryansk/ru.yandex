package practicum.module_2.lesson_Map.Task_2;

import java.util.HashMap;
import java.util.Map;

public class Practicum {
    // Создадим хеш-таблицу для хранения заказов.
    // В качестве ключа будет имя клиента.
    // В качестве значения — количество заказов от этого клиента.
    private Map<String, Integer> orders = new HashMap<>();

    public static void main(String[] args) {
        Practicum pizzeria = new Practicum();
        pizzeria.openPizzeria();
        pizzeria.printStatistics();
    }

    // Начинаем принимать заказы! 🍕
    private void openPizzeria() {
        newOrder("Леонардо");
        newOrder("Донателло");
        newOrder("Рафаэль");
        newOrder("Леонардо");
        newOrder("Микеланджело");
        newOrder("Шреддер");
        newOrder("Донателло");
    }

    private void newOrder(String clientName) {
        // Сохраните новый заказ в хеш-таблицу. При обновлении счётчика заказов
        // не забудьте учесть заказы, которые уже были сделаны ранее.
        int count = orders.getOrDefault(clientName, 0);
        orders.put(clientName, ++count);

       /* int counter = 1;
        if (!orders.containsKey(clientName)) {
            counter = 1;
            orders.put(clientName, counter);
        } else if (orders.containsKey(clientName)) {
            counter += orders.get(clientName);
            orders.put(clientName, counter);
        }*/
    }

    private void printStatistics() {
        // Выведите собранную статистику в консоль и посчитайте общее количество заказов.
        //
        // Формат для вывода данных в консоль:
        //     Заказов от Микеланджело: 15
        //     Заказов от Леонардо: 4
        //     Всего заказов: 19
        int countAllOrder = 0;
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            System.out.println("Заказов от " + entry.getKey() + " : " + entry.getValue());
            countAllOrder = countAllOrder + entry.getValue();
        }
        System.out.println("Всего заказов: " + countAllOrder);
    }
}
