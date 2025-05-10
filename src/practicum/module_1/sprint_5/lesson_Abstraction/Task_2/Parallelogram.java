package practicum.module_1.sprint_5.lesson_Abstraction.Task_2;

public abstract class Parallelogram implements Figure {
    private final double h;
    private final double w;

    public Parallelogram(double h, double w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public double getArea() {
        return h * w;
    }

}