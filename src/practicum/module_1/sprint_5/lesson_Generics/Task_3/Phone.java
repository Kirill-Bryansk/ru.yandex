package practicum.module_1.sprint_5.lesson_Generics.Task_3;

// унаследуйте класс от базового класса, описывающего контакт Contact
public class Phone extends Contact {
    private final String phoneNumber;
    public Phone(String name, String phoneNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @Override
    public void sendMessage() {
        System.out.println("Звоним другу по номеру " + phoneNumber + " и зовем на кофе.");
    }
    @Override
    public void print() {
        System.out.println("Номер телефона: " + getPhoneNumber());
    }
}
