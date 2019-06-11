package homework9;

import java.util.ArrayList;
import java.util.List;

public class LinkedListImplementation <T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedListImplementation() {
        this.size = 0;
    }

    private static class Node<T> {
        Node<T> previous;
        T item;
        Node<T> next;

        public Node(Node<T> previous, T item, Node<T> next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    public void linkFirst(T node) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(null, node, first);
        first = newNode;
        if(f == null) {
            last = newNode;
        } else {
            f.previous = newNode;
        }
        size++;
    }

    public void linkLast(T node) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(last, node, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public int size() {
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

    public void add(T value) {
        if (first == null) {
            linkFirst(value);
        } else {
            linkLast(value);
        }
    }

    public void add(T value, int index) {
        if (index > size || index < 0) {
            System.out.println("Wrong index. Need 0 <= index <= size");
        } else if (index == size) {
            add(value);
        } else {
            Node<T> currentNode = last;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
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

    public void addAll(List<T> list) {
        for (T node: list) {
            linkLast(node);
        }
    }

    public T get(int index) {
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

    public Node<T> getNode(int index) {
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

    public T remove(int index) {
        T delItem;
        Node<T> currentNode = getNode(index);
        Node<T> preNode = currentNode.previous;
        Node<T> afterNode = currentNode.next;
        preNode.next = afterNode;
        afterNode.previous = preNode;
        size--;
        delItem = currentNode.item;
        return delItem;
    }

    public T remove(T t) {
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
                return delItem;
            }
        }
        return t;
    }

    @Override
    public String toString() {
        return "LinkedListImplementation{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        LinkedListImplementation implementation = new LinkedListImplementation();
        implementation.add(5);
        System.out.println(implementation.get(0).toString());
        implementation.add(13);
        System.out.println(implementation.get(1).toString());
        implementation.add(2);
        System.out.println(implementation.get(2).toString());
        implementation.add(111, 2);
        System.out.println(implementation.get(2).toString());
        implementation.add(444, 2);
        System.out.println(implementation.get(3).toString());
        System.out.println(implementation.get(4).toString());
        System.out.println("Size : " + implementation.size());
        implementation.addAll(list);
        System.out.println(implementation.get(7).toString());

    }
}
