package practicum.module_1.sprint_2.calorie_counter;

public class Converter {
    int stepLengthСentimeters = 75;
    int stepEnergyCalorie = 50;
    int caloriePerKilocalories = 1000;

    int convertToKm(int steps) {
        int metersInKilometer = 1000;
        int centimetersInMeter = 100;
        int convertToKm = (steps * stepLengthСentimeters / centimetersInMeter) / metersInKilometer;
        return convertToKm;
    }

    int convertStepsToKilocalories(int steps) {
        int convertStepsToKilocalories = (steps * stepEnergyCalorie) / caloriePerKilocalories;
        return convertStepsToKilocalories;
    }
}


