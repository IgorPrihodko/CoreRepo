package homework10;

import java.util.Map;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    Node<K, V>[] arrayOfNodes;
    int size;

    public MyHashMap() {
    }

    public V get(K key) {
        return getNode(key).getValue();
    }

    public V put(K key, V value) {
        if ((arrayOfNodes == null || arrayOfNodes.length == 0) ^ size == arrayOfNodes.length * LOAD_FACTOR) {
            arrayOfNodes = resize(arrayOfNodes);
        }
        Node<K, V> positionNode = arrayOfNodes[hash(key) % arrayOfNodes.length];
        if (positionNode == null) {
            arrayOfNodes[hash(key) % arrayOfNodes.length] = new Node<>(key, value, null);
            size++;
        } else if (positionNode.getKey().equals(key) && positionNode.hash == hash(key)) {
            V oldValue = positionNode.getValue();
            arrayOfNodes[hash(key) % arrayOfNodes.length].setValue(value);
            return oldValue;
        } else if (!positionNode.getKey().equals(key) && positionNode.hash == hash(key)) {
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
                nextInBucket = new Node<>(key, value, null);
                size++;
            }
        }
        return null;
    }

    public Node<K, V> getNode(K key) {
        Node<K, V> firstInBucket = arrayOfNodes[hash(key) % arrayOfNodes.length];
        Node<K, V> nextInBucket = firstInBucket.next;
        if (arrayOfNodes != null && arrayOfNodes.length > 0 && firstInBucket != null) {
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

    public Node<K, V>[] resize(Node<K, V>[] oldArrayOfNodes) {
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
        int hash;
        public K key;
        public V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
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

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?, ?> node = (Node<?, ?>) o;

            if (!getKey().equals(node.getKey())) return false;
            return getValue().equals(node.getValue());
        }

        @Override
        public int hashCode() {
            int result = getKey().hashCode();
            result = 31 * result + getValue().hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Key = " + key + '\n' + "Value = " + value;
        }
    }

    public static final int hash(Object key) {
        int hash;
        return (key == null) ? 0 : (hash = key.hashCode()) ^ (hash >>> 16);
    }
}
