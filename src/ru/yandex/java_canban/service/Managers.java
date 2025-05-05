package ru.yandex.java_canban.service;


import ru.yandex.java_canban.model.Task;

import java.util.List;

public class Managers  {

    public static InMemoryTaskManager getDefault () {
        return new InMemoryTaskManager();
    }

    public static InMemoryHistoryManager getDefaultHistory () {
        return new InMemoryHistoryManager();
    }

}
