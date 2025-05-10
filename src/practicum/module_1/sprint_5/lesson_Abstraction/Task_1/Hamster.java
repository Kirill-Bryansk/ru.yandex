package practicum.module_1.sprint_5.lesson_Abstraction.Task_1;

public class Hamster extends Pet {
    public Hamster() {
        super(4, "Фу-фу фу");
    }
    public void hideFood() {
        System.out.println("Вся еда - в щечках!");
    }
}
