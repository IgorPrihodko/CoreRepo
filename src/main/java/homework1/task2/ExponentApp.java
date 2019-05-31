package homework1.task2;

public class ExponentApp {

    public static void main(String[] args) {
        ExponentApp exponent = new ExponentApp();
        exponent.calculation(2, 40);
    }

    private long calculation(int number, int exponent) {
        long result = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result = result * number;
            }
        }
        System.out.println(result);
        return result;
    }
}
