package homework9;

import java.util.List;

public class LinkedListImplementation <T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    LinkedListImplementation() {
        this.size = 0;
    }

    private static class Node<T> {
        private Node<T> previous;
        private T item;
        private Node<T> next;

        Node(Node<T> previous, T item, Node<T> next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    private void linkFirst(T value) {
        Node<T> newNode = new Node<>(null, value, null);
        first = newNode;
        last = first;
        size++;
    }

    private void linkLast(T value) {
        Node<T> newNode = new Node<>(last, value, null);
        last.next = newNode;
        last = newNode;
        size++;
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

    public boolean isEmpty() {
        return size() == 0;
    }

    void add(T value) {
        if (first == null) {
            linkFirst(value);
        } else {
            linkLast(value);
        }
    }

    void add(T value, int index) {
        if (index > size || index < 0) {
            System.out.println("Wrong index. Need 0 <= index <= size");
        } else if (index == size) {
            add(value);
        } else {
            Node<T> currentNode = getNode(index);
            Node<T> preNode = currentNode.previous;
            Node<T> newNode = new Node<>(preNode, value, currentNode);
            currentNode.previous = newNode;
            if (preNode == null) {
                first = newNode;
            } else {
                preNode.next = newNode;
            }
        }
        size++;
    }

    void addAll(List<T> list) {
        for (T node: list) {
            linkLast(node);
        }
    }

    T get(int index) {
        if (index >= 0 && index < size) {
            if (index <= (size / 2)) {
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
        } else {
            System.out.println("Wrong index. Need 0 <= index < size");
        }
        return null;
    }

    private Node<T> getNode(int index) {
        if (index >= 0 && index < size) {
            if (index < (size / 2)) {
                Node<T> node = first;
                for (int i = 0; i < index; i++)
                    node = node.next;
                return node;
            } else {
                Node<T> node = last;
                for (int i = size - 1; i > index; i--)
                    node = node.previous;
                return node;
            }
        } else {
            System.out.println("Wrong index. Need 0 <= index < size");
        }
        return null;
    }

    public void set(T value, int index) {
        getNode(index).item = value;
    }

    T remove(int index) {
        T delItem;
        Node<T> currentNode = getNode(index);
        Node<T> preNode = currentNode.previous;
        Node<T> afterNode = currentNode.next;
        preNode.next = afterNode;
        afterNode.previous = preNode;
        size--;
        delItem = currentNode.item;
        currentNode = null;
        return delItem;
    }

    public T remove(T t) {
        Node<T> currentNode = first;
        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;
            if (currentNode.item.equals(t)) {
                remove(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "LinkedListImplementation{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }
}
