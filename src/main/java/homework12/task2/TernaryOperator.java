package homework12.task2;

import java.util.function.Function;
import java.util.function.Predicate;

public class TernaryOperator {
    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition,
                                                        Function<? super T, ? extends U> ifTrue,
                                                        Function<? super T, ? extends U> ifFalse) {
        return result -> condition.test(result) ? ifTrue.apply(result) : ifFalse.apply(result);
    }
}
