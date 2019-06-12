package homework9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        LinkedListImplementation implementation = new LinkedListImplementation();
        implementation.add(5);
        System.out.println(implementation.get(0).toString());
        implementation.add(13);
        System.out.println(implementation.get(1).toString());
        implementation.add(2);
        System.out.println(implementation.get(2).toString());
        implementation.add(111, 2);
        System.out.println(implementation.get(2).toString());
        implementation.add(444, 2);
        implementation.remove(3);
        System.out.println(implementation.get(3).toString());
        System.out.println(implementation.get(2).toString());
        System.out.println("Size : " + implementation.size());
        implementation.addAll(list);
        System.out.println(implementation.get(6).toString());
    }
}
