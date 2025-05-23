package practicum.module_1.sprint_5.lesson_Generics.Task_2;

// Дополните класс для проверки возраста пользователя
public class AgeValidationRule extends ValidationRule<Byte> {

    public AgeValidationRule(Byte age) {
        super(age, "Возраст для подачи на ипотеку должен быть старше 18 лет");
    }

    @Override
    public boolean isValid() {
        return value >= 18;
    }

}