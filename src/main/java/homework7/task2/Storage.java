package homework7.task2;

public class Storage <K, V> {
    private K key;
    private V value;
    private K[] keyArr;
    private V[] valueArr;

    public Storage() {
    }

    private void setNewObject(K key, V value) {
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

    private K[] newArrK(K[] oldArr) {
        if (oldArr == null) {
            K[] newArr = (K[]) new Object[10];
            return newArr;
        } else {
            K[] newArr = (K[]) new Object[oldArr.length * 2 + 1];
            System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
            return newArr;
        }
    }

    private V[] newArrV(V[] oldArr) {
        if (oldArr == null) {
            V[] newArr = (V[]) new Object[10];
            return newArr;

        } else {
            V[] newArr = (V[]) new Object[oldArr.length * 2 + 1];
            System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
            return newArr;
        }
    }

    private V get(K key) {
        V value = null;
        for (int i = 0; i < keyArr.length; i++) {
            if (key == keyArr[i])
                value = valueArr[i];
        }
        return value;
    }

    private void put(K key, V value) {
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] == key) {
                valueArr[i] = value;
                return;
            }
        }
    }

    public static void main(String[] args) {
        Storage Storage = new Storage();
        Storage.setNewObject(12, "Got it!");
        Storage.setNewObject(10, "Good");
        System.out.println(Storage.get(10));
        Storage.put(10, "Bad");
        System.out.println(Storage.get(12));
        System.out.println(Storage.get(10));

    }
}
