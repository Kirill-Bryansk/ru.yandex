package practicum.module_1.sprint_3.dinner_constructor;

import java.util.ArrayList;
import java.util.HashMap;



public class MenuDishes {
    ArrayList<String> dishes;
    HashMap<String, ArrayList<String>> menu;
    ArrayList<String> chosenTypes;



    MenuDishes() {
        dishes = new ArrayList<>();
        menu = new HashMap<>();
        chosenTypes = new ArrayList<>();
    }

    void saveDishMenu(String key, String value) {
        menu.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
}
