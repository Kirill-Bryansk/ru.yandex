package practicum.module_1.sprint_5.lesson_Abstraction.Task_2;

public class Circle implements Figure{
    // Радиус круга
    private final double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }
}