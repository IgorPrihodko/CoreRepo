package homework4.task6;

public class MealApp {
    public static void main(String[] args) {

        Meal firstPerson = new MealDirector(new JapaneseMealBuilder()).costructMeal().getMeal();
        Meal secondherson = new MealDirector(new ItalianMealBuilder()).costructMeal().getMeal();
        System.out.println("First: " + firstPerson);
        System.out.println("Second: " + secondherson);
    }
}
