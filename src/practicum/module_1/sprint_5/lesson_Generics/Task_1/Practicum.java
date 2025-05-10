package practicum.module_1.sprint_5.lesson_Generics.Task_1;

import java.util.ArrayList;
import java.util.HashMap;

public class Practicum {
    public static void main(String[] args) {
        //создаём двухуровневую хеш-таблицу для хранения расписания уроков
        AdvancedHashMap<String, Integer, String> timetable = new AdvancedHashMap<>();
        //добавляем уроки, с указанием дня недели и номера урока
        timetable.put("Понедельник", 1, "Русский язык");
        timetable.put("Понедельник", 2, "Математика");
        timetable.put("Вторник", 1, "Физкультура");
        timetable.put("Вторник", 2, "Русский язык");

        //выводим первый урок во вторник
        System.out.println(timetable.get("Вторник", 1));

        //получаем и выводим все уроки в понедельник
        ArrayList<String> mondayLessons = timetable.getAll("Понедельник");
        System.out.println(mondayLessons);
    }

}

class AdvancedHashMap <K1, K2, V> {
    //данные будем хранить в хеш-таблице из хеш-таблиц
    HashMap<K1, HashMap<K2, V>> internalHashMap = new HashMap<>();

    public void put(K1 day, K2 numLesson, V lesson) {
        //получаем хеш-таблицу по первому ключу
        HashMap<K2, V> innerHashMap = internalHashMap.get(day);
        if (innerHashMap == null) {
            //вложенной хеш-таблицы по первому ключу пока нет — создаём её и добавляем в internalHashMap
            innerHashMap = new HashMap<>();
            internalHashMap.put(day, innerHashMap);
        }
        //добавляем элемент во вложенную хеш-таблицу
        innerHashMap.put(numLesson, lesson);
    }

    public V get(K1 day, K2 numLesson) {
        //получаем хеш-таблицу по первому ключу
        HashMap<K2, V> innerHashMap = internalHashMap.get(day);
        if (innerHashMap == null) {
            return null;
        }
        //получаем элемент из вложенной хеш-таблицы
        return innerHashMap.get(numLesson);
    }

    public ArrayList<V> getAll(K1 day) {
        HashMap<K2, V> innerHashMap = internalHashMap.get(day);
        if (innerHashMap == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(innerHashMap.values());
    }
}

