package homework7.task1;

class Pair <K, V> {

    private K key;
    private V value;

    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    private Pair() {
    }

    public static <K, V> Pair of(K key, V value) {
        return new Pair<>(key, value);
    }

    public K getFirst() {
        return key;
    }
    public V getSecond() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        if (key != null) {
            if (!key.equals(pair.key)) {
                return false;
            } else if (pair.key != null) {
                return false;
            }
        }
        if (value != null) {
            return value.equals(pair.value);
        } else {
            return pair.value == null;
        }
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        if (value != null) {
            result = 31 * result + value.hashCode();
        } else {
            result = 31 * result;
        }
        return result;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst();
        String s = pair.getSecond();

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode();
    }
}
