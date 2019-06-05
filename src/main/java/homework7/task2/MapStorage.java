package homework7.task2;
/*Создайте хранилище типа КЛЮЧ - ЗНАЧЕНИЕ, которое параметризируется 2-умя типами данных,
     и в этом хранилище можо класть значение по ключу и доставать значение по ключу.
  Пример: Storage<Integer, Box> storage = new Storage<>();  storage.put(22, box); storage.get(22) // вернёт коробку.*/
public class MapStorage {

    private int key;
    private String value;
    private int[] keyArr;
    private String[] valueArr;

    private MapStorage() {
    }

    private void setNewObject(int key, String value) {
        if (keyArr == null && valueArr == null) {
            keyArr = newArrInt(keyArr);
            valueArr = newArrString(valueArr);
        }
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] == 0 && valueArr[i] == null) {
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

    private static int[] newArrInt(int[] oldArr) {
        if (oldArr == null) {
            return new int[10];
        } else {
            int[] newArr = new int[oldArr.length * 2 + 1];
            System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
            return newArr;
        }
    }

    private static String[] newArrString(String[] oldArr) {
        if (oldArr == null) {
            return new String[10];
        } else {
            String [] newArr = new String[oldArr.length * 2 + 1];
            System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
            return newArr;
        }
    }

    private String get(int key) {
        String value = null;
        for (int i = 0; i < keyArr.length; i++) {
            if (key == keyArr[i])
                value = valueArr[i];
        }
        return value;
    }

    private void put(int key, String value) {
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] == key) {
                valueArr[i] = value;
                return;
            }
        }
    }

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
