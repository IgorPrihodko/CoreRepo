package homework2.task1;

public class BoolExpression {

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a ^ b) && (c ^ d) || (a ^ c) && (b ^ d) || (a ^ d);
    }
}
