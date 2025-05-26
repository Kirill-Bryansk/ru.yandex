package practicum.module_1.sprint_4.lesson_Extends.Task_2;

class Automobile extends Transport {
    public Automobile() {
        wheelsNumber = 4;
    }

    protected String direction;

    public void turnTo(String worldSide) {
        direction = worldSide;
    }
}
