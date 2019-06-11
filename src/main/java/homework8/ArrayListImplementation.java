package homework8;

import java.util.Arrays;
import java.util.List;

public class ArrayListImplementation<T> {
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private T[] typeArr;
    private int size;

    public ArrayListImplementation(int initialCapacity) {
        if (initialCapacity > 0) {
            this.typeArr = (T[]) new Object[initialCapacity];
            this.size = 0;
        } else if (initialCapacity == 0) {
            this.typeArr =(T[]) EMPTY_ELEMENTDATA;
            this.size = 0;
        } else {
            throw new IllegalArgumentException("Wrong capacity: " + initialCapacity);
        }
    }

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return this.typeArr == EMPTY_ELEMENTDATA;
    }

    private void add(T value) {
        if (isEmpty() || size == typeArr.length) {
            T[] newArr = (T[]) new Object[(typeArr.length * 3) / 2 + 1];
            System.arraycopy(typeArr, 0, newArr, 0, typeArr.length);
            typeArr = newArr;
            typeArr[size] = value;
        } else {
            typeArr[size] = value;
        }
        size++;
    }

    private void add(T value, int index) {
        if (index < 0) {
            System.out.println("Wrong index. Need index >= 0");
            return;
        }
        if (isEmpty()) {
            typeArr = (T[]) new Object[index + 1];
            typeArr[index] = value;
        } else if (index <= typeArr.length) {
            T[] newArr = (T[]) new Object[(typeArr.length * 3) / 2 + 1];
            System.arraycopy(typeArr, 0, newArr, 0, index);
            System.arraycopy(typeArr, index, newArr, index + 1, typeArr.length - index);
            typeArr = newArr;
            typeArr[index] = value;
        } else if (index > typeArr.length) {
            T[] newArr = (T[]) new Object[index + 1];
            System.arraycopy(typeArr, 0, newArr, 0, typeArr.length);
            typeArr = newArr;
            typeArr[index] = value;
        }
        size++;
    }

    private void addAll(List<T> list) {
        T[] newArr = (T[]) new Object[typeArr.length + list.size()];
        System.arraycopy(typeArr, 0, newArr, 0, typeArr.length);
        System.arraycopy(list, 0, newArr, typeArr.length, list.size());
        typeArr = newArr;
        size = size + list.size();
    }

    T get(int index) {
        return typeArr[index];
    }

    public void set(T value, int index) {
        if (index >= 0) {
            typeArr[index] = value;
        } else {
            System.out.println("Wrong index. Need index >= 0");
        }
    }

    public T remove(int index) {
        if (index >= 0 && index < typeArr.length) {
            T value = typeArr[index];
            T[] newArr = (T[]) new Object[typeArr.length - 1];
            System.arraycopy(typeArr, 0, newArr, 0, index);
            System.arraycopy(typeArr, index + 1, newArr, index, typeArr.length - index - 1);
            typeArr = newArr;
            size--;
            return value;
        } else {
            System.out.println("Wrong index. Need 0 <= index < size");
            return null;
        }
    }

    public T remove(T t) {
        for (int i = 0; i < typeArr.length; i++) {
            if (typeArr[i] == t) {
                remove(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ArrayListImplementation{" +
                "typeArr=" + Arrays.toString(typeArr) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        ArrayListImplementation list = new ArrayListImplementation(10);
        System.out.println(list.size());
        list.add(100);
        list.add(11);
        list.add(2, 5);
        System.out.println(list.toString());
        list.add(2, -5);
        System.out.println(list.toString());
        list.remove(5);
        System.out.println(list.toString());
    }
}
