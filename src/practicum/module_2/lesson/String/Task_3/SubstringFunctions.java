package practicum.module_2.lesson.String.Task_3;

public class SubstringFunctions {
    public boolean startsWith(String initial, String other) {
        if (initial.indexOf(other)!=-1){
            return true;
        } else {
            return false;
        }
    }
}
