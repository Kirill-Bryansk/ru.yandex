package practicum.module_1.sprint_3.dinner_constructor;

import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    Random random = new Random();
    ArrayList<String> comboDishes = new ArrayList<>();

    void printCombos(int numberOfCombos, MenuDishes md) {
        for (int j = 0; j < numberOfCombos; j++) {
            for (int i = 0; i < md.chosenTypes.size(); i++) {
                String type = md.chosenTypes.get(i);
                md.dishes.addAll(md.menu.get(type));
                int bound = random.nextInt(md.dishes.size());
                comboDishes.add(md.dishes.get(bound));
                md.dishes.clear();
            }
            System.out.println("Комбо " + (j + 1));
            System.out.println(comboDishes);
            comboDishes.clear();
        }
        md.chosenTypes.clear();
    }
}


