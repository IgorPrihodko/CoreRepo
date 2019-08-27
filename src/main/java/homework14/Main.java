package homework14;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private void countWords() {
        Scanner scanner = new Scanner(System.in);
        Stream.of(scanner
                .nextLine()
                .toLowerCase()
                .split("[^\\p{L}\\p{Digit}_]+"))
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new))
                .entrySet()
                .stream()
                .sorted(Comparator
                        .comparingLong((ToLongFunction<Map.Entry<String, Long>>) Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e.getKey()));
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.countWords();
    }
}
