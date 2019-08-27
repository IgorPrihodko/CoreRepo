package homework13.task2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializable {
    public static Animal[] deserializeAnimalArray(byte[] data) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = objectInputStream.readInt();
            Animal[] animals = new Animal[size];
            for (int i = 0; i < size; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }
            for (Animal a : animals) {
                System.out.println(a);
            }
            return animals;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException();
        }
    }
}
