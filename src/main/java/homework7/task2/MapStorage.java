package homework7.task2;

public class MapStorage <Integer, String> {
    private Integer[] keyArr;
    private String[] valueArr;

    MapStorage() {
    }

    public void setNewObject(Integer key, String value) {
        if (keyArr == null && valueArr == null) {
            keyArr = newArrInt(keyArr);
            valueArr = newArrString(valueArr);
        }
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] == null && valueArr[i] == null) {
                keyArr[i] = key;
                valueArr[i] = value;
                return;
            }
            if (i == keyArr.length - 1) {
                keyArr = newArrInt(keyArr);
                valueArr = newArrString(valueArr);
                keyArr[i + 1] = key;
                valueArr[i + 1] = value;

            }
        }
    }

    public Integer[] newArrInt(Integer[] oldArr) {
        if (oldArr == null) {
            Integer[] newArr = (Integer[]) new Object[10];
            return newArr;
        } else {
            Integer[] newArr = (Integer[]) new Object[oldArr.length * 2 + 1];
            System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
            return newArr;
        }
    }

    public String[] newArrString(String[] oldArr) {
        if (oldArr == null) {
            String[] newArr = (String[]) new Object[10];
            return newArr;
        } else {
            String [] newArr = (String[]) new Object[oldArr.length * 2 + 1];
            System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
            return newArr;
        }
    }

    public String get(Integer key) {
        String value = null;
        for (int i = 0; i < keyArr.length; i++) {
            if (key == keyArr[i])
                value = valueArr[i];
        }
        return value;
    }

    public void put(Integer key, String value) {
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] == key) {
                valueArr[i] = value;
                return;
            }
        }
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
    }
}