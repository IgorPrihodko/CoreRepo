package homework10;

import java.util.Arrays;
import java.util.Map;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Node<K, V>[] arrayOfNodes;
    private int size;

    public V get(K key) {
        if (getNode(key)== null) {
            return null;
        }
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
        } else if ((key == null && positionNode.getKey() == null) ||
                (!key.equals(positionNode.getKey()) && hash(key) == positionNode.hash) ||
                !key.equals(positionNode.getKey()) && !(hash(key) == positionNode.hash)) {
            if (positionNode.next == null) {
                positionNode.next = new Node<>(key, value, null, hash(key));
                size++;
            } else {
                Node<K, V> nextInBucket = positionNode.next;
                while (nextInBucket.next != null) {
                    if (nextInBucket.key.equals(key)) {
                        V oldValue = nextInBucket.getValue();
                        nextInBucket.setValue(value);
                        return oldValue;
                    }
                    nextInBucket = nextInBucket.next;
                }
                nextInBucket.next = new Node<>(key, value, null, hash(key));
                size++;
            }
        } else if (positionNode.getKey().equals(key)
                && positionNode.hash == hash(key)) {
            V oldValue = positionNode.getValue();
            arrayOfNodes[hash(key) % arrayOfNodes.length].setValue(value);
            return oldValue;
        }
        return null;
    }

    protected Node<K, V> removeNode(K key) {
        Node<K, V> currentNode = getNode(key);
        if (currentNode.next != null) {
            arrayOfNodes[hash(key) % arrayOfNodes.length] = currentNode.next;
        } else {
            arrayOfNodes[hash(key) % arrayOfNodes.length] = null;
        }
        size--;
        return currentNode;
    }

    protected Node<K, V> getNode(K key) {
        if (arrayOfNodes[hash(key) % arrayOfNodes.length] != null) {
            Node<K, V> firstInBucket = arrayOfNodes[hash(key) % arrayOfNodes.length];
            Node<K, V> nextInBucket = firstInBucket.next;
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
        return null;
    }

    private Node[] resize(Node[] oldArrayOfNodes) {
        Node[] newArrayOfNodes = new Node[oldArrayOfNodes.length * 2];
        for (int i = 0; i < oldArrayOfNodes.length; i++) {
            Node oldNode = oldArrayOfNodes[i];
            if (oldNode != null) {
                if (oldNode.next == null) {
                    newArrayOfNodes[oldNode.hash % newArrayOfNodes.length] = oldNode;
                } else {
                    do {
                        newArrayOfNodes[oldNode.hash % newArrayOfNodes.length] = oldNode;
                        oldNode = oldNode.next;
                    }
                    while (oldNode.next != null);
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
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private static int hash(Object key) {
        int hashKey;
        return (key == null) ? 0 : (hashKey = key.hashCode()) ^ (hashKey >>> 16);
    }

    @Override
    public String toString() {
        return "MyHashMap " +
                "arrayOfNodes=" + Arrays.toString(arrayOfNodes) +
                ", size=" + size +
                ", capacity=" + arrayOfNodes.length + '\n';
    }
}
