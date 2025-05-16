package practicum.module_2.lesson_Lists.Task_1.Task_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PotatoLaboratory {

    public static void main(String[] args) {
        List<Potato> potatoes = List.of(
                new Potato(1, 30, 30, 30),
                new Potato(2, 35, 31, 35),
                new Potato(3, 40, 35, 44),
                new Potato(4, 28, 44, 41),
                new Potato(5, 33, 23, 30),
                new Potato(6, 35, 33, 33),
                new Potato(7, 38, 41, 24)
        );

        List<Potato> fourUnderExperiment = findPotatoesForExperiment(potatoes);

        System.out.println("Картофелины для эксперимента: " + fourUnderExperiment);
    }

    private static List<Potato> findPotatoesForExperiment(List<Potato> potatoes) {
				/* Вычислите две самые большие и две самые маленькие картофелины,
           а затем выведите их в порядке от самых маленьких до самых больших.*/
        final ArrayList<Potato> mutablePotatoes = new ArrayList<>(potatoes);
        final ArrayList<Potato> experimentPotatoesList =
                new ArrayList<>(List.of(Collections.min(mutablePotatoes), Collections.max(mutablePotatoes)));
        mutablePotatoes.removeAll(experimentPotatoesList);
        experimentPotatoesList.add(Collections.max(mutablePotatoes));
        experimentPotatoesList.add(Collections.min(mutablePotatoes));
        Collections.sort(experimentPotatoesList);
        return experimentPotatoesList;
    }
    /*final ArrayList<Potato> mutablePotatoes = new ArrayList<>(potatoes);
    Collections.sort(mutablePotatoes, Potato::compareTo);
    final ArrayList<Potato> experimentPotatoesList = new ArrayList<>(mutablePotatoes);
        experimentPotatoesList.add(Collections.min(mutablePotatoes));
        experimentPotatoesList.add(Collections.max(mutablePotatoes));
        mutablePotatoes.remove(Collections.max(mutablePotatoes));
        mutablePotatoes.remove(Collections.min(mutablePotatoes));
        experimentPotatoesList.add(Collections.max(mutablePotatoes));
        experimentPotatoesList.add(Collections.min(mutablePotatoes));
        Collections.sort(experimentPotatoesList);
        return experimentPotatoesList;*/

}
