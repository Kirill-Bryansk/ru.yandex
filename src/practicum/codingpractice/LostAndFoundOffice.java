package practicum.codingpractice;
import java.util.ArrayList;

public class LostAndFoundOffice {
    ArrayList<Object> things = new ArrayList<>();
    public void put(Object element) {
        things.add(element);
    }
    public boolean check(Object target) {
        if(target == null) {
            return false;
        }
        for (Object object : things) {
            if(object.equals(target)) {
                return true;
            }
        }
        return false;
    }
}

