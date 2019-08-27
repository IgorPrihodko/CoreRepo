package homework12.task1;

import java.util.function.DoubleUnaryOperator;

public class Integrate {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        final double h = 10e-6;
        double result;
        result = 0;
        int n = (int)((b - a) / h);

        for(int i = 0; i < n; i++) {
            result += f.applyAsDouble(a + h * i);
        }
        result = result * h;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));
    }
}
