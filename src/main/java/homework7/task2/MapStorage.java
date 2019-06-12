package homework7.task2;

import java.util.Arrays;

public class MapStorage <K, V> {
    private K[] keyArr;
    private V[] valueArr;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MapStorage() {
        this.keyArr = (K[]) new Object[DEFAULT_CAPACITY];
        this.valueArr = (V[]) new Object[DEFAULT_CAPACITY];
    }

    public void setNewObject(K key, V value) {
        if (keyArr.length == size && valueArr.length == size) {
            keyArr = newArrK(keyArr);
            valueArr = newArrV(valueArr);
        }
        keyArr[size] = key;
        valueArr[size] = value;
        size++;
    }

    public K[] newArrK(K[] oldArr) {
        if (oldArr == null) {
            return (K[]) new Object[DEFAULT_CAPACITY];
        } else {
            K[] newArr = (K[]) new Object[oldArr.length * 2 + 1];
            System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
            return newArr;
        }
    }

    public V[] newArrV(V[] oldArr) {
        if (oldArr == null) {
            return (V[]) new Object[DEFAULT_CAPACITY];
        } else {
            V[] newArr = (V[]) new Object[oldArr.length * 2 + 1];
            System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
            return newArr;
        }
    }

    public V get(K key) {
        V value = null;
        for (int i = 0; i < keyArr.length; i++) {
            if (key == keyArr[i])
                value = valueArr[i];
        }
        return value;
    }

    public void put(K key, V value) {
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] == key) {
                valueArr[i] = value;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "MapStorage{" +
                "keyArr=" + Arrays.toString(keyArr) +
                ", valueArr=" + Arrays.toString(valueArr) +
                ", size=" + size +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        MapStorage mapStorage = new MapStorage();
        mapStorage.setNewObject(12, "Got it!");
        mapStorage.setNewObject(10, "Good");
        System.out.println(mapStorage.get(10));
        mapStorage.put(10, "Bad");
        System.out.println(mapStorage.get(12));
        System.out.println(mapStorage.get(10));
        mapStorage.setNewObject(15, "hi!");
        System.out.println(mapStorage.get(15));
    }
}