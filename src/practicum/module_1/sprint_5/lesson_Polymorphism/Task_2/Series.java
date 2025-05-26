package practicum.module_1.sprint_5.lesson_Polymorphism.Task_2;

public class Series implements MediaItem {

    private final String title;
    private final int averageRuntime;
    private final int seriesCount;

    public Series(String title, int averageRuntime, int seriesCount) {
        this.title = title;
        this.averageRuntime = averageRuntime;
        this.seriesCount = seriesCount;
    }

    @Override
    public int getRuntime() {
        return averageRuntime;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getSeriesCount() {
        return seriesCount;
    }
}
