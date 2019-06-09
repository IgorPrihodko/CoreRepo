package homework6.task3;

import homework6.task2.CarCloneApp;

/*реализуйте метод deepClone который принимает объект любого класса и возвращает глубокую копию этого класса*/
public class AnyObjectDeepCloneApp implements Cloneable {

    private Object inputObject;

    public AnyObjectDeepCloneApp(Object inputObject) {
        this.inputObject = inputObject;
    }

    public Object getInputObject() {
        return inputObject;
    }

    public void setInputObject(Object inputObject) {
        this.inputObject = inputObject;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
       try {
           return (AnyObjectDeepCloneApp)super.clone();
       } catch (CloneNotSupportedException c) {
           return new AnyObjectDeepCloneApp(getInputObject());
       }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        AnyObjectDeepCloneApp car = new AnyObjectDeepCloneApp(new CarCloneApp("red", "disel"));
        AnyObjectDeepCloneApp copy = (AnyObjectDeepCloneApp)car.clone();
        System.out.println(car.getInputObject().equals(copy.inputObject));
    }
}
