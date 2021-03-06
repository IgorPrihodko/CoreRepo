package homework7.task2;

public class Storage <K, V> {
    private K[] keyArr;
    private V[] valueArr;

    public Storage() {
    }

    public void setNewObject(K key, V value) {
        if (keyArr == null && valueArr == null) {
            keyArr = newArrK(keyArr);
            valueArr = newArrV(valueArr);
        }
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] == null && valueArr[i] == null) {
                keyArr[i] = key;
                valueArr[i] = value;
                return;
            }
            if (i == keyArr.length - 1) {
                keyArr = newArrK(keyArr);
                valueArr = newArrV(valueArr);
                keyArr[i + 1] = key;
                valueArr[i + 1] = value;
            }
        }
    }

    public K[] newArrK(K[] oldArr) {
        if (oldArr == null) {
            K[] newArr = (K[]) new Object[10];
            return newArr;
        } else {
            K[] newArr = (K[]) new Object[oldArr.length * 2 + 1];
            System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
            return newArr;
        }
    }

    public V[] newArrV(V[] oldArr) {
        if (oldArr == null) {
            V[] newArr = (V[]) new Object[10];
            return newArr;

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

    public static void main(String[] args) {
        Storage Storage = new Storage();
        Storage.setNewObject(12, "Got it, Man!");
        Storage.setNewObject(10, "Good, Lady");
        System.out.println(Storage.get(10));
        Storage.put(10, "Bad, come on");
        System.out.println(Storage.get(12));
        System.out.println(Storage.get(10));
        Storage.setNewObject(14, "Hi!");
    }
}
