package homework3.task2;

import java.math.BigInteger;

public class FactorialApp {

    public static void main(String[] args) {

        System.out.println(FactorialApp.factorial(110));
    }

    private static BigInteger factorial(int value) {
        BigInteger bigValue = BigInteger.valueOf(value);
        if (value == 1 || value == 0) {
            return BigInteger.ONE;
        } else {
            return  bigValue.multiply(factorial(value - 1));
        }
    }
}
