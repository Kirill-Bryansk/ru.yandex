package ru.yandex.java_canban.service;
import ru.yandex.java_canban.model.*;

import java.util.*;

public class Manager implements TaskManager {
    private final HashMap<Integer, Task> taskMap = new HashMap<>();
    private final HashMap<Integer, Epic> epicMap = new HashMap<>();
    private final HashMap<Integer, Subtask> subtaskMap = new HashMap<>();

    private int count = 1;

}