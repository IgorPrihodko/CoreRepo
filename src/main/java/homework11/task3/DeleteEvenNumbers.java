package homework11.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DeleteEvenNumbers {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            listOfNumbers.add(scanner.nextInt());
        }
        for (int i = 0; i < listOfNumbers.size(); i++) {
            if (i % 2 == 0) {
                listOfNumbers.set(i, null);
            }
        }
        listOfNumbers.removeAll(Collections.singletonList(null));
        Collections.reverse(listOfNumbers);
        for (Integer number: listOfNumbers) {
                System.out.print(number + " ");
        }
    }
}
