package homework11.task2;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static  <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> resultSet = new HashSet<>();
        for (T set: set1) {
            if (!set2.contains(set)) {
                resultSet.add(set);
            }
        }
        for (T set: set2) {
            if (!set1.contains(set)) {
                resultSet.add(set);
            }
        }
        return resultSet;
    }
}
