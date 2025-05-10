package practicum.module_1.sprint_5.lesson_Polymorphism.Task_2;

import java.util.List;

public class Calculator {
    private static final int MINUTES = 60;
    private static final int HOURS = 24;

    private Calculator() {}

    public static double calculate(List<MediaItem> mediaItems) {
        int totalRuntime = 0;
        for (MediaItem mediaItem : mediaItems) {
            if (mediaItem instanceof Series) {
                Series series = (Series) mediaItem;
                totalRuntime += series.getRuntime() * series.getSeriesCount();
            } else if (mediaItem instanceof Movie) {
                Movie movie = (Movie) mediaItem;
                totalRuntime += movie.getRuntime();
            }
        }
        return ((double) totalRuntime) / MINUTES / HOURS;
    }
}