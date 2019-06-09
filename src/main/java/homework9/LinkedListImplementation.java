package homework9;

import java.util.List;

public class LinkedListImplementation <T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public LinkedListImplementation() {
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> previous;

        public Node(T item, Node<T> next, Node<T> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }

    }

    void linkFirst(T node) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(node, first, null);
        first = newNode;
        if(f == null) {
            last = newNode;
        } else {
            f.previous = newNode;
            size++;
        }
    }

    void linkLast(T node) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(node, null, last);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
            size++;
        }
    }

    int size() {
        if (first == null && last == null) {
            size = 0;
        } else {
            size = 1;
            while (first.next != null) {
                first = first.next;
                size++;
            }
        }
        return size;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    void add(T value) {
        linkLast(value);
    }

    void add(T value, int index) {
        Node<T> preNode;
        Node<T> afterNode;
        if (index == size) {
            afterNode = null;
            preNode = last;
        } else {
            Node<T> currentNode = last;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
            afterNode = currentNode;
            preNode = afterNode.previous;
        }
        size++;
    }

    void addAll(List<T> list) {
        for (T node : list) {
            linkLast(node);
        }
    }

    T get(int index) {
        if (index < (size >> 1)) {
            Node<T> currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.item;
        } else {
            Node<T> currentNode = last;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
            return currentNode.item;
        }
    }

    void set(T value, int index) {
        Node<T> currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.item = value;
    }

    T remove(int index) {
        Node<T> currentNode = first;
        T delItem;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        Node<T> preNode = currentNode.previous;
        Node<T> afterNode = currentNode.next;
        preNode.next = afterNode;
        afterNode.previous = preNode;
        size--;
        delItem = currentNode.item;
        currentNode.item = null;
        return delItem;
    }

    T remove(T t) {
        Node<T> currentNode = first;
        T delItem;
        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;
            if (currentNode.item == t) {
                Node<T> preNode = currentNode.previous;
                Node<T> afterNode = currentNode.next;
                preNode.next = afterNode;
                afterNode.previous = preNode;
                size--;
                delItem = currentNode.item;
                currentNode.item = null;
                return delItem;
            }
        }
        return t;
    }
}
