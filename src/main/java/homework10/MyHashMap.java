package homework10;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Node<K, V>[] arrayOfNodes;
    private int size;

    public V get(K key) {
        return getNode(key).getValue();
    }

    protected V put(K key, V value) {
        if ((arrayOfNodes == null || arrayOfNodes.length == 0)) {
            arrayOfNodes = new Node[DEFAULT_CAPACITY];
        }
        if (size >= arrayOfNodes.length * LOAD_FACTOR) {
            arrayOfNodes = resize(arrayOfNodes);
        }
        Node<K, V> positionNode = arrayOfNodes[hash(key) % arrayOfNodes.length];
        if (positionNode == null) {
            arrayOfNodes[hash(key) % arrayOfNodes.length] = new Node<>(key, value, null, hash(key));
            size++;
        } else if (positionNode.getKey().equals(key) && positionNode.hash == hash(key)) {
            V oldValue = positionNode.getValue();
            arrayOfNodes[hash(key) % arrayOfNodes.length].setValue(value);
            return oldValue;
        } else if (!(positionNode.getKey().equals(key)) && positionNode.hash == hash(key) ||
                !(positionNode.getKey().equals(key)) && !(positionNode.hash == hash(key))) {
            Node<K, V> nextInBucket = positionNode.next;
            if (nextInBucket != null) {
                do {
                    if (nextInBucket.key.equals(key)) {
                        V oldValue = nextInBucket.getValue();
                        nextInBucket.setValue(value);
                        return oldValue;
                    }
                } while (nextInBucket.next != null);
            } else {
                nextInBucket = new Node<>(key, value, null, hash(key));
                size++;
            }
        }
        return null;
    }

    protected Node<K, V> removeNode(K key) {
        if (getNode(key) != null) {
            Node<K, V> currentNode = getNode(key);
            if (currentNode.next != null) {
                arrayOfNodes[hash(key) % arrayOfNodes.length] = currentNode.next;
            } else {
                arrayOfNodes[hash(key) % arrayOfNodes.length] = null;
            }
            size--;
            return currentNode;
        }
        return null;
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> firstInBucket = arrayOfNodes[hash(key) % arrayOfNodes.length];
        Node<K, V> nextInBucket = firstInBucket.next;
        if (arrayOfNodes != null && arrayOfNodes.length > 0) {
            if (firstInBucket != null) {
                if (firstInBucket.key == null && key == null || firstInBucket.key.equals(key)) {
                    return firstInBucket;
                }
                if (nextInBucket != null) {
                    do {
                        if (nextInBucket.key.equals(key)) {
                            return nextInBucket;
                        }
                    } while (nextInBucket.next != null);
                }
            }
        }
        return null;
    }

    private Node<K, V>[] resize(Node<K, V>[] oldArrayOfNodes) {
        Node<K, V>[] newArrayOfNodes;
        if (oldArrayOfNodes.length > 0) {
            newArrayOfNodes = new Node[oldArrayOfNodes.length * 2];
        } else {
            newArrayOfNodes = new Node[DEFAULT_CAPACITY];
        }
        Node<K, V> oldNode;
        for (int i = 0; i < oldArrayOfNodes.length; i++) {
            oldNode = oldArrayOfNodes[i];
            if (oldArrayOfNodes[i] != null) {
                oldArrayOfNodes[i] = null;
                if (oldNode.next == null) {
                    newArrayOfNodes[oldNode.hash % newArrayOfNodes.length] = oldNode;
                } else {
                    Node<K, V> oldNodeNext = oldNode.next;
                    do {
                        newArrayOfNodes[oldNodeNext.hash % newArrayOfNodes.length] = oldNodeNext;
                    }
                    while (oldNodeNext.next != null);
                }
            }
        }
        return newArrayOfNodes;
    }

    public static class Node<K, V> implements Map.Entry<K, V> {
        public K key;
        public V value;
        Node<K, V> next;
        public int hash;

        public Node(K key, V value, Node<K, V> next, int hash) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(getKey(), node.getKey()) &&
                    Objects.equals(getValue(), node.getValue()) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {

            return Objects.hash(getKey(), getValue(), next);
        }

        @Override
        public String toString() {
            return '\n' + "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private static int hash(Object key) {
        int hashKey;
        return (key == null) ? 0 : (hashKey = key.hashCode())/* ^ (hashKey >>> 16)*/;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "arrayOfNodes=" + Arrays.toString(arrayOfNodes) +
                ", size=" + size +
                '}' + ", capacity=" + arrayOfNodes.length + '\n';
    }
}
