package homework7.task2;

public class Storage <K, V> {
    private K key;
    private V value;

    public Storage() {
    }

    public Storage(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V get(K key) {
        return value;
    }

    public void put(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        Storage <Integer, String> storage = new Storage<>();
        storage.put(12, "first");
        System.out.println(storage.get(12));
    }
}
