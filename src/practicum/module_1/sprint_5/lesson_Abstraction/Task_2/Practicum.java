package practicum.module_1.sprint_5.lesson_Abstraction.Task_2;

public class Practicum {

    public static void main(String[] args) {
        Figure rectangle = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника 4см*6см = " + rectangle.getArea());

        Figure square = new Square(3);
        System.out.println("Площадь квадрата 3см*3см = " + square.getArea());

        Figure rhombus = new Rhombus(4, 3);
        System.out.println("Площадь ромба со стороной 4см и высотой 3см = " + rhombus.getArea());

        Figure circle = new Circle(2);
        System.out.println("Площадь круга с радиусом 2см = " + circle.getArea());
    }

}