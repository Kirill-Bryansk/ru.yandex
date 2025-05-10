package practicum.module_1.sprint_5.lesson_Generics.Task_3;

// ограничьте класс ContactBook так, чтобы он мог хранить в себе только список контактов
import java.util.ArrayList;
import java.util.List;
public class ContactBook<T extends Contact> {
    // объявите поле класса contacts — список контактов книги
    private final List<T> contacts = new ArrayList<>();

    public void addContact(T contact) {
        contacts.add(contact);
    }

    public void printList() {
        // выведите на экран весь список контактов книги
        for (T contact : contacts) {
            System.out.println("Имя: " + contact.getName());
            contact.print();
        }
    }
    public void congratulate(String name) {
        boolean contactPresented = false; // проверяем, есть ли контакт в базе
        // найдите контакт в книге по имени и отправьте ему сообщение с помощью метода sendMessage()
        for (T contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.println("Поздравим с Новым годом ваш контакт из записной книжки: " + name);
                contact.sendMessage();
                contactPresented = true;
            }
        }  // если контакт не найден, выведите соответствующее сообщение
        if (!contactPresented) {
            System.out.println("Не найден контакт с указанным именем.");
        }
    }
}
