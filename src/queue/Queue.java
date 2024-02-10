package queue;

import linkedList.LinkedList;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private RuntimeException exception() {
        return new RuntimeException("Queue is empty");
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;

        tail = node;
        size++;
    }

    public T dequeue() {
        if(size == 0) throw exception();

        T data = head.data;
        head = head.next;

        size--;

        return data;
    }

    public T peek() {
        if(size < 1) throw new RuntimeException("Queue is empty!");

        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            sb.append(currentNode.data).append(", ");

            currentNode = currentNode.next;
        }

        sb.append(currentNode.data);
        sb.append(']');

        return sb.toString();
    }
}
