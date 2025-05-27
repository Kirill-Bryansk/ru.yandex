package practicum.module_2.just;

public class Practicum {
    public static void main(String[] args) {
        StringBuilder initial = new StringBuilder("Большая красная кнопка");

        initial.replace(8, 15, "белая");
        initial.delete(14, 30);
        initial.append("груша");
        initial.setLength(7);
        initial.reverse();

        System.out.println(initial.toString().toLowerCase());
    }
}