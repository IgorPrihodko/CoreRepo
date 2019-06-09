package homework8;

import java.util.List;

public class ArrayListImplementation<T> {

    private T[] typeArr;
    private int size;

    public ArrayListImplementation() {
    }

    int size() {
        int size = 0;
        for (T aTypeArr : typeArr) {
            size++;
        }
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void add(T value) {
        T[] newArr = (T[]) new Object[size + 1];
        System.arraycopy(typeArr, 0, newArr, 0, typeArr.length);
        typeArr = newArr;
        typeArr[size++] = value;
    }

    void add(T value, int index) {
        T[] newArr = (T[]) new Object[size + 1];
        System.arraycopy(typeArr, 0 , newArr, 0, size - index);
        System.arraycopy(typeArr, index, newArr, index + 1, size - index);
        typeArr = newArr;
        typeArr[index] = value;
    }

    void addAll(List<T> list) {
        T[] newArr = (T[]) new Object[size + list.size()];
        System.arraycopy(typeArr, 0, newArr, 0, typeArr.length);
        System.arraycopy(list, 0, newArr, size + 1, list.size());
        typeArr = newArr;
    }

    T get(int index) {
        return typeArr[index];
    }

    void set(T value, int index) {
        typeArr[index] = value;
    }

    T remove(int index) {
        T value = typeArr[index];
        T[] newArr = (T[]) new Object[size - 1];
        System.arraycopy(typeArr, 0, newArr, 0, index);
        System.arraycopy(typeArr, index + 1, newArr, index, size - index - 1);
        typeArr = newArr;
        return value;
    }

    T remove(T t) {
        for (int i = 0; i < size; i++) {
            T value = typeArr[i];
            if (typeArr[i] == t) {
                T[] newArr = (T[]) new Object[size - 1];
                System.arraycopy(typeArr, 0, newArr, 0, i);
                System.arraycopy(typeArr, i + 1, newArr, i , size - i - 1);
                typeArr = newArr;
                return value;
            }
        }
        return null;
    }
}
