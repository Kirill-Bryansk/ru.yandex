package practicum.module_1.sprint_4.lesson_Encapsulation.Task_1;


//package ru.yandex.practicum.work;
public class WorkCalculator {

    public int workingHours = 8;
    String workerName;
    public double coefficient;

    WorkCalculator(String newName) {
        workerName = newName;
    }

    public String getWorkerName() {
        return workerName;
    }

    int calculate(int workDays) {
        return workDays * workingHours;
    }

    double calculateWithCoefficient(int workDays) {
        return workDays * workingHours * coefficient;
    }
}