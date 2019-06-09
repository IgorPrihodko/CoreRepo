package homework6.task2;

import java.io.Serializable;

public class Car implements Cloneable, Serializable {

    private String color;
    private String engine;
    private Weel weel;

    public Car(String color, String engine, Weel weel) {
        this.color = color;
        this.engine = engine;
        this.weel = weel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Weel getWeel() {
        return weel;
    }

    public void setWeel(Weel weel) {
        this.weel = weel;
    }

    @Override
    public Object clone() {
        Car car;
        try {
            car = (Car) super.clone();
        }  catch (CloneNotSupportedException c) {
            car = new Car(this.color, this.engine, this.weel);
        }
        car.weel = (Weel) car.weel.clone();
        return car;
    }
}
