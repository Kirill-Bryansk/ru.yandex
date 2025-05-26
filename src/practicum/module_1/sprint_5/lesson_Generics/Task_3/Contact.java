package practicum.module_1.sprint_5.lesson_Generics.Task_3;

// дополните объявление класса Contact
public abstract class Contact {
    // класс должен содержать одно полe — имя пользователя name


    // и два три метода — getName(), sendMessage() для отправки сообщения и print() для печати информации о контакте

    private final String name;
    protected Contact(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract void sendMessage();
    public abstract void print();
}

