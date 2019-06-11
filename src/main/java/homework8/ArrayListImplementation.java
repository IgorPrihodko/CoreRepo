package homework8;

import java.util.Arrays;
import java.util.List;

public class ArrayListImplementation<T> {
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private T[] arrayOfValues;
    private int size;

    public ArrayListImplementation() {
        this.arrayOfValues = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayListImplementation(int initialCapacity) {
        if (initialCapacity > 0) {
            this.arrayOfValues = (T[]) new Object[initialCapacity];
            this.size = 0;
        } else if (initialCapacity == 0) {
            this.arrayOfValues = (T[]) new Object[DEFAULT_CAPACITY];
            this.size = 0;
        } else {
            throw new IllegalArgumentException("Wrong capacity: " + initialCapacity);
        }
    }

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void add(T value) {
        if (isEmpty()) {
            arrayOfValues = (T[]) new Object[DEFAULT_CAPACITY];
        } else if (size == arrayOfValues.length) {
            T[] newArr = (T[]) new Object[(arrayOfValues.length * 3) / 2 + 1];
            System.arraycopy(arrayOfValues, 0, newArr, 0, arrayOfValues.length);
            arrayOfValues = newArr;
        }
        arrayOfValues[size] = value;
        size++;
    }

    private void add(T value, int index) {
        if (index < 0 || index > size) {
            System.out.println("Wrong index. Need 0 <= index <= size");
            return;
        }
        if (isEmpty() || index == size) {
            add(value);
        } else {
            T[] newArr = (T[]) new Object[(arrayOfValues.length * 3) / 2 + 1];
            System.arraycopy(arrayOfValues, 0, newArr, 0, index);
            System.arraycopy(arrayOfValues, index, newArr, index + 1, arrayOfValues.length - index);
            arrayOfValues = newArr;
            arrayOfValues[size] = value;
        }
        size++;
    }

    private void addAll(List<T> list) {
        if (arrayOfValues.length < size + list.size()) {
            T[] newArr = (T[]) new Object[arrayOfValues.length + list.size()];
            System.arraycopy(arrayOfValues, 0, newArr, 0, arrayOfValues.length);
            System.arraycopy(list.toArray(), 0, newArr, arrayOfValues.length, list.size());
            arrayOfValues = newArr;
            size = size + list.size();
        } else {
            for (T value: list) {
                add(value);
            }
        }
    }

    public T get(int index) {
        return arrayOfValues[index];
    }

    private void set(T value, int index) {
        if (index >= 0 && index <= size) {
            arrayOfValues[index] = value;
        } else {
            System.out.println("Wrong index. Need index >= 0");
        }
    }

    private T remove(int index) {
        if (index >= 0 && index < arrayOfValues.length) {
            T value = arrayOfValues[index];
            T[] newArr = (T[]) new Object[arrayOfValues.length - 1];
            System.arraycopy(arrayOfValues, 0, newArr, 0, index);
            System.arraycopy(arrayOfValues, index + 1, newArr, index, arrayOfValues.length - index - 1);
            arrayOfValues = newArr;
            size--;
            return value;
        } else {
            System.out.println("Wrong index. Need 0 <= index < size");
            return null;
        }
    }

    private T remove(T t) {
        for (int i = 0; i < arrayOfValues.length; i++) {
            if (arrayOfValues[i] == t) {
                remove(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ArrayListImplementation{" +
                "typeArr=" + Arrays.toString(arrayOfValues) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        ArrayListImplementation list = new ArrayListImplementation(10);
        System.out.println(list.size());
        list.add(100);
        list.add(11);
        list.add(2, 2);
        System.out.println(list.toString());
        list.add(2, -5);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());
    }
}
