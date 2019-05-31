package homework4.task6;

public class MealDirector {

    private MealBuilder mealBuilder;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public MealDirector costructMeal() {
        mealBuilder.buildDrink();
        mealBuilder.buildMainCourse();
        mealBuilder.buildSide();
        return this;
    }

    public Meal getMeal() {
        return mealBuilder.getMeal();
    }
}
