package java_kanban.service;

import java_kanban.service.model.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private final Map<Integer, Node<Task>> historyMap = new HashMap<>();
    Node<Task> head;
    Node<Task> tail;

    @Override
    public void add(Task task) {
        if (historyMap.containsKey(task.getId())) {
            Node<Task> removeNode = historyMap.get(task.getId());
            removeNode(removeNode);
        } else {
            linkLast(task);
            Node<Task> newNode = tail;
            historyMap.put(task.getId(), newNode);
        }
    }

    @Override
    public List<Task> getHistory() {
        return getTasks();
    }

    @Override
    public void remove(int id) {
        if (historyMap.containsKey(id)) {
            Node<Task> node = historyMap.get(id);
            removeNode(node);
        }
    }

    private void linkLast(Task task) {
        final Node<Task> oldTail = tail;
        final Node<Task> newNode = new Node<>(oldTail, task, null);
        tail = newNode;
        if (oldTail == null) {
            head = newNode;
        } else {
            oldTail.next = newNode;
        }
    }

    public List<Task> getTasks() {
        List<Task> historyList = new ArrayList<>();
        Node<Task> saveNode = head;
        while (saveNode != null) {
            historyList.add(saveNode.iteam);
            saveNode = saveNode.next;
        }
        return historyList;
    }

    public void removeNode(Node<Task> node) {
        if (node == head) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (node == tail) {
            tail = node.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        historyMap.remove(node.iteam.getId());
    }

    private static class Node<Task> {
        Task iteam;
        Node<Task> next;
        Node<Task> prev;

        public Node(Node<Task> prev, Task iteam, Node<Task> next) {
            this.iteam = iteam;
            this.next = next;
            this.prev = prev;
        }
    }
}