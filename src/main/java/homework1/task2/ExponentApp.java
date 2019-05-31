package homework1.task2;

public class ExponentApp {

    public static void main(String[] args) {
        ExponentApp exponent = new ExponentApp();
        System.out.println(exponent.calculation(2, -4));
    }

    private double calculation(int number, int exponent) {
        double result = 1;
        if (exponent >= 0) {
            for (int i = 0; i < exponent; i++) {
                result = result * number;
            }
        } else {
            for (int i = 0; i < (-exponent); i++) {
                result =  result * number;
            }
            result = 1 / result;
        }
        return result;
    }
}
