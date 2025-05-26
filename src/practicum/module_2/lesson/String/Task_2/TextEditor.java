package practicum.module_2.lesson.String.Task_2;

public class TextEditor {

    private boolean isCapsLock = false;

    public void capsLock() {
        // Здесь нужно изменить значение флага isCapsLock на противоположное
        if (!isCapsLock) {
            isCapsLock = true;
        } else {
            isCapsLock = false;
        }
    }

    public void print(String str) {
        // а здесь нужно распечатать строку или в верхнем регистре, или без изменений, учитывая флаг
        if (!isCapsLock) {
            System.out.println(str);
        } else {
            System.out.println(str.toUpperCase());
        }
    }
}
