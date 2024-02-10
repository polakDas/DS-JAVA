package linkedList;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // insert in the last - O(1)
    public void add(T data) {
        Node<T> node = new Node<>(data);
        size++;

        if(head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;

        tail = node;
    }

    // inset in the first - O(1)
    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        size++;

        if(head == null) {
            head = tail = node;
            return;
        }

        head.prev = node;
        node.next = head;

        head = node;
    }

    public void insert(int index, T data) { // O(n)
        if (isInvalid(index)) throw exception();
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            add(data);
            return;
        }

        Node<T> node = new Node<>(data);
        Node<T> tempHead = head;

        for (int i = 1; i < index; i++) {
            tempHead = tempHead.next;
        }
        Node<T> tempNext = tempHead.next;

        tempHead.next = node;
        node.prev = tempHead;
        node.next = tempNext;
        tempNext.prev = node;

        size++;
    }

    public void replace(int index, T data) {    // O(n)
        if (isInvalid(index)) throw exception();

        if (index == 0) {
            head.data = data;
            return;
        }
        if (index == size) {
            tail.data = data;
            return;
        }

        Node<T> tempHead = head;
        for (int i = 0; i < index; i++) {
            tempHead = tempHead.next;
        }
        tempHead.data = data;
    }

    public T removeFirst() {    // O(1)
        if(size < 1) throw exception();
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }

        size--;

        return data;
    }

    public T removeLast() { // O(1)
        if (size < 1) throw exception();
        T data = tail.data;
        tail = tail.prev;
        if(tail != null) {
            tail.next = null;
        } else {
            head = null;
        }

        size--;

        return data;
    }

    public void remove(int index) { // O(n)
        if(index < 0 || index >= size) throw exception();

        if(index == 0) {
            removeFirst();
            return;
        }
        if(index == size - 1) {
            removeLast();
            return;
        }

        Node<T> tempHead = head;
        while(index-- > 1) {
            tempHead = tempHead.next;
        }

        tempHead.next = tempHead.next.next;
        tempHead.next.prev = tempHead;

        size--;
    }

    public void remove(T item) {    // O(n)
        if(size == 1) {
            head = tail = null;
            return;
        }
        if(size < 1) {
            System.out.println("No item in linked list!!");
            return;
        }
        Node<T> tempHead = head;
        for(int i = 0; i < size; i++) {
            if(tempHead.data.equals(item)) {
                tempHead.prev.next = tempHead.next;
                tempHead.next.prev = tempHead.prev;

                size--;

                return;
            }
            tempHead = tempHead.next;
        }
        System.out.println("Item not found!");
    }

    public T get(int index) {   // O(n)
        if(index < 0 || index >= size) throw exception();

        if(index == size - 1) {
            return tail.data;
        }

        Node<T> tempHead = head;
        for (int i = 0; i < index; i++) {
            tempHead = tempHead.next;
        }

        return tempHead.data;
    }

    public int indexOf(T item) {    // O(n)
        Node<T> tempHead = head;
        for (int i = 0; i < size; i++) {
            if (tempHead.data.equals(item)) {
                return i;
            }
            tempHead = tempHead.next;
        }

        return -1;
    }

    public int size() {  // O(1)
        return size;
    }

    private boolean isInvalid(int index) {
        return index > size || index < 0;
    }

    private ArrayIndexOutOfBoundsException exception() {
        return new ArrayIndexOutOfBoundsException("Array index out of index");
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