package stack;

import linkedList.LinkedList;

public class Stack<T> extends LinkedList<T> {
    Node<T> head;
    int size = 0;
    public static class Node<T>{
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
        }
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);

        if(size != 0) {
            newNode.next = head;
        }

        head = newNode;
        size++;
    }

    public void pushLL(T data) {
        super.addFirst(data);
    }

    public T popLL() {
        return super.removeFirst();
    }

    public T peekLL() {
        return super.get(0);
    }

    public int sizeLL() {
        return super.size();
    }

    public T peek() {
        if(size < 1) {
            throw new StackOverflowError("Stack is empty!");
        }

        return head.data;
    }

    public T pop() {
        if(size < 1) {
            throw new StackOverflowError("Stack is empty!");
        }

        T temp = head.data;
        head = head.next;
        size--;

        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

//    @Override
//    public String toString() {
//        if (size() == 0) return "[]";
//
//        StringBuilder sb = new StringBuilder();
//        sb.append('[');
//
//        Node<T> currentNode = head;
//
//        while (currentNode.next != null) {
//            sb.append(currentNode.data).append(", ");
//            currentNode = currentNode.next;
//        }
//
//        sb.append(currentNode.data);
//        sb.append(']');
//
//        return sb.toString();
//    }

    public String toString() {
        return super.toString();
    }
}
