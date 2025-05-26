package practicum.module_1.sprint_5.lesson_Polymorphism.Task_1;

public class Smartphone extends Phone {

    public Smartphone(String number) {
        super(number);
    }
    // объявите метод sendEmail()
    void sendEmail(String messageText, String email) {
        System.out.println("Напишем другу сообщение " + messageText + " по email " + email);
    }

    void makeCall(String targetNumber, String appName) {
        System.out.println("Позвоним через приложение " + appName + " по номеру " + targetNumber);
    }

}