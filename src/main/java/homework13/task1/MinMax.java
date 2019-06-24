package homework13.task1;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinMax {
    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.size() == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            T max = list.stream().max(order).get();
            T min = list.stream().min(order).get();
            minMaxConsumer.accept(min, max);
        }
    }
}
