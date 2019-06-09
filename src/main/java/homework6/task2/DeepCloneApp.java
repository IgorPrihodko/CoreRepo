package homework6.task2;

public class DeepCloneApp {
    public static void main(String[] args) {
        Weel weel = new Weel("Comanche", "Large");
        Car car = new Car("red", "disel", weel);
        Car deepCopyCar = (Car) car.clone();

        System.out.println(car.getColor());
        System.out.println(deepCopyCar.getColor());

        car.setColor("blue");
        System.out.println(car.getColor());
        System.out.println(deepCopyCar.getColor());
    }
}
