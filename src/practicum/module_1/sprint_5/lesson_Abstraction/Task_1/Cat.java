package practicum.module_1.sprint_5.lesson_Abstraction.Task_1;

public class Cat extends Pet {
    public Cat() {
        super(4, "Мяу");
    }
    public void catchMouse() {
        System.out.println("Поймала мышку!");
    }
}