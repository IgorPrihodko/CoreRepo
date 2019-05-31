package homework2.task3;

public class EqualsDouble {
    private static final double E = 0.0001;

    public static boolean doubleExpression(double a, double b, double c) {

        return -E <= (c - (a + b)) && (c - (a + b))<= E;
    }
}
