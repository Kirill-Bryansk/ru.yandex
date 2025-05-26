package practicum.module_1.sprint_4.lesson_Extends.Task_2;

class TexlaTruck extends Transport {
    protected double maxSpeedByDirt;

    public TexlaTruck() {
        maxSpeedByDirt = 30;
    }

    public void accelerateByDirt() {
        if (speed < maxSpeedByDirt) {
            speed += acceleration * 0.5;
        }
    }

    public void brakeByDirt() {
        if (speed > 0) {
            speed -= brakingSpeed * 0.5;
        }
    }
}
