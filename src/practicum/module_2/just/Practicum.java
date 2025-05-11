package practicum.module_2.just;

import java.util.ArrayList;
import java.util.List;

public class Practicum {

    public static void main(String[] args) {

        final List<String> cats = new ArrayList<>(); //[Маркиз, Пирожок, Лев]

        cats.add("Маркиз");
        cats.add("Принцесса");
        cats.add("Пирожок");
        cats.add("Мурка");
        cats.remove(1);
        cats.set(2,"Лев");



        System.out.println(cats); // сейчас печатается [Маркиз, Принцесса, Пирожок, Мурка]
    }
}