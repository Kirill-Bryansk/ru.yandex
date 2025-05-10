package practicum.module_1.sprint_5.lesson_Polymorphism.Task_1;

public class MobilePhone extends Phone {
    public MobilePhone(String number) {
        super(number);
    }

    //объявите метод sendSms()
    void sendSms(String messageText, String  targetNumber) {
        System.out.println("Отправляем сообщение " + messageText + " по номеру " + targetNumber);
    }
}
