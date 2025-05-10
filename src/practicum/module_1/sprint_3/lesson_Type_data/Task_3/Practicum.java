package practicum.module_1.sprint_3.lesson_Type_data.Task_3;

public class Practicum {
    public static void main(String[] args) {
        String pixelKcalDay = "43"; // столько калорий съел Пиксель до похода к бабушке
        String beefKcal = "30.2"; // калорийность говядины
        String chickenKcal = "23.8"; // калорийность курицы 111111
        String creamKcal = "32.1"; // калорийность сливок
        String milkKcal = "13.5"; // калорийность молока 222222

        float pixelChoice = getMinKcalsSum(beefKcal, chickenKcal, creamKcal, milkKcal);
        Float totalKcal = Integer.parseInt(pixelKcalDay) + pixelChoice;
        checkKcal(totalKcal);
    }

    private static Float getMinKcalsSum(String firstDishKcal, String secondDishKcal, String firstDesert, String secondDesert) {
        float fD1 = Float.parseFloat(firstDishKcal);
        float sD2 = Float.parseFloat(secondDishKcal);
        float minDishKcal = Float.min((float)fD1, (float)sD2); // вычислите минимальную калорийность основного блюда
        float fD3 = Float.parseFloat(firstDesert);
        float sD4 = Float.parseFloat(secondDesert);
        float minDesertKcal = Float.min((float)fD3, (float)sD4); // вычислите минимальную калорийность десерта
        return minDishKcal + minDesertKcal;
    }

    private static void checkKcal(Float catKcal) {
        if (catKcal == null) {
            System.out.println("Что-то пошло не так");
        } else {
            System.out.println("Калорийность рациона Пикселя за день: " + catKcal);
            if (catKcal > 100) {
                System.out.println("Пиксель сегодня не уложился в норму.");
            } else {
                System.out.println("Лимит не превышен!");
            }
        }
    }
}