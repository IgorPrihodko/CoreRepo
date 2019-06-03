package homework1.task3;

public class RhombusApp {

    public static void main(String[] args) {
        RhombusApp rhombus = new RhombusApp();
        rhombus.drawRhombus(5);
    }

    private void drawRhombus(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = number - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = number - 1; i > 0; i--) {
            for (int j =number; j > i ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i ; j++) {
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
