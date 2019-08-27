package homework12.task3;

import java.util.stream.IntStream;

public class PseudoRandomStream {
    public static IntStream pseudoRandomStream(int seed) {
        IntStream randomStream = IntStream.iterate(seed, n -> n*n/10%1000);
        return randomStream;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            pseudoRandomStream(i).limit(20).mapToObj(x -> " " + x).forEachOrdered(System.out::print);
            System.out.println();
        }
    }
}
