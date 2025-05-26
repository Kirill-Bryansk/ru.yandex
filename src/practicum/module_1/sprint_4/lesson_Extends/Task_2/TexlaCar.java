package practicum.module_1.sprint_4.lesson_Extends.Task_2;

class TexlaCar extends Automobile {
    protected double autoPilotMaxSpeed;
    protected double autoPilotAcceleration;

    public TexlaCar() {
        autoPilotMaxSpeed = 60;
        autoPilotAcceleration = 10;
    }

    public void accelerateByAutopilot() {
        if (speed < autoPilotMaxSpeed) {
            if (speed < autoPilotMaxSpeed) {
                speed += autoPilotAcceleration;
                speed += autoPilotAcceleration;
            }
        }
    }
}