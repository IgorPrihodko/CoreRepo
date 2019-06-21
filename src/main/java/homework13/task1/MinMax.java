package homework13.task1;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class MinMax {
    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        T[] arr = (T[]) stream.sorted(order).toArray();
        if (arr.length > 0) {
            minMaxConsumer.accept(arr[0], arr[arr.length - 1]);
        } else {
            minMaxConsumer.accept(null, null);
        }
        /*List<? extends T> list = stream.collect(Collectors.toList());
        minMaxConsumer.accept(Collections.min(list, order), Collections.max(list, order));*/
    }
}
