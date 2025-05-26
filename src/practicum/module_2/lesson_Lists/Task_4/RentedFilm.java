package practicum.module_2.lesson_Lists.Task_4;

public class RentedFilm {
    private final String name;
    private final DateTime timeOfRent;
    private final DateTime timeOfReturn;

    public RentedFilm(String name, DateTime timeOfRent, DateTime timeOfReturn) {
        this.name = name;
        this.timeOfRent = timeOfRent;
        this.timeOfReturn = timeOfReturn;
    }

    public String getName() {
        return name;
    }

    public DateTime getTimeOfRent() {
        return timeOfRent;
    }

    public DateTime getTimeOfReturn() {
        return timeOfReturn;
    }
}
