package homework4.task5;

public class MathSqrtException {

    public static double sqrt(double x) {

        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        } else {
            return Math.sqrt(x);
        }
    }
}
