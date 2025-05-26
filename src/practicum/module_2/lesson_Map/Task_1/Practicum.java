package practicum.module_2.lesson_Map.Task_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practicum {
    // Пример списка пассажиров (на самом деле их больше)
    private static List<String> passengerNames = List.of(
            "Василий Петров",
            "Анна Ягирская",
            "Виктория Сотова",
            "Игорь Серов",
            "Людмила Ульянова"
    );

    public static void main(String[] args) {
        Map<String, Integer> seats = assignSeats(passengerNames);
        System.out.println("Места пассажиров: " + seats);
    }

    public static Map<String, Integer> assignSeats(List<String> passengerNames) {
        // Тут нужно написать код, который будет распределять места в самолёте ✈️
        /*for (Map.Entry<String, Integer> entry : passengerNames.entrySet()) {
            System.out.println("'" + entry.getKey() + "' содержит " + entry.getValue() + " калорий в 100 г.");
        }*/
        Map<String, Integer> assignSeats = new HashMap<>();
        for (int i = 0; i < passengerNames.size(); i++) {
            assignSeats.put(passengerNames.get(i), i + 1);
        }
        return assignSeats;
    }
}
