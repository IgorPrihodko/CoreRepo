package homework6.task2;

public class CarCloneApp implements Cloneable {

    private String color;
    private String engine;

    public CarCloneApp(String color, String engine) {
        this.color = color;
        this.engine = engine;
    }

    private String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public Object clone() {
        try {
            return (CarCloneApp)super.clone();
        }  catch (CloneNotSupportedException c) {
            return new CarCloneApp(this.color, this.engine);
        }
    }

    public static void main(String[] args) {
        CarCloneApp car = new CarCloneApp("red", "disel");
        CarCloneApp deepCopyCar = (CarCloneApp) car.clone();
        System.out.println(deepCopyCar.getColor().equals(car.getColor()));
        System.out.println(deepCopyCar.getEngine().equals(car.getEngine()));
    }
}
