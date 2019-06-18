package homework11.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CollectionMain {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = new ArrayList<>();
        List<Integer> reversedList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            listOfNumbers.add(scanner.nextInt());
        }
        for (int i = 1; i < listOfNumbers.size(); i += 2) {
          reversedList.add(listOfNumbers.get(i));
        }
        Collections.reverse(reversedList);
        for (Integer number: reversedList) {
            System.out.print(number + " ");
        }
    }
}
