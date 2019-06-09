package homework4.task6;

public class MealApp {

    public static void main(String[] args) {
        Meal meal = new Meal.Builder().setSide("icecream").setDrink("juice").setMainCourse("fish").buildMeal();
        System.out.println(meal);
    }
}
