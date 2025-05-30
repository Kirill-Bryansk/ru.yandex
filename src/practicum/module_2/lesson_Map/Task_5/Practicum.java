package practicum.module_2.lesson_Map.Task_5;

import java.util.HashMap;
import java.util.Map;

class Practicum {
    private static Map<Long, User> users = new HashMap<>();

    public static void main(String[] args) {
        // создадим 1 миллион пользователей
        for (long i = 1; i <= 1_000_000L; i++) {
            users.put(i, new User(i, "Имя " + i));
        }

        final long startTime = System.nanoTime();
        User user = findUser(378_366L);
        final long endTime = System.nanoTime();

        System.out.println("Найден пользователь: " + user);
        System.out.println("Поиск занял " + (endTime - startTime) + " наносекунд.");
    }

    private static User findUser(Long userId) {
        User user = users.get(userId);
        users.get(userId);

        /*for (User user : users) {
            if (user.id.equals(userId)) {
                return user;
            }*/
        return user;
    }

    static class User {
        Long id;
        String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        public String toString() {
            return "User{id=" + id + ", name='" + name + "'}";
        }
    }
}
