package practicum.module_1.sprint_2.calorie_counter;

class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " День: " + days[i] + " шагов пройдено.");
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;

        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps)
                maxSteps = days[i];// поиск максимального элемента
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries = currentSeries + 1;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }// поиск максимальной серии
        }
        return finalSeries;
    }

    int averageValue() {
        int averageValue = 0;
        int staticVariable = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] != 0) {
                staticVariable = staticVariable + 1;
            }
        }
        averageValue = sumStepsFromMonth() / staticVariable;
        return averageValue;
    }
}


