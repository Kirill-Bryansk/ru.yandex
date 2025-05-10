package practicum.module_1.sprint_4.lesson_Inheritance.Task_2;

class Train extends Transport {
    public Train() {
        wheelsNumber = 8;
    }

    private boolean isLocomotive;

    public void turnToLocomotive() {
        isLocomotive = true;
    }

    public void turnToСarriage() {
        isLocomotive = false;
    }
}