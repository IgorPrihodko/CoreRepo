package homework4.task6;

public class Meal {

    private final String drink;
    private final String mainCourse;
    private final String side;

    public String getDrink() {
        return drink;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    public String getSide() {
        return side;
    }

    public Meal(Builder builder) {
        drink = builder.drink;
        mainCourse  = builder.mainCourse;
        side = builder.side;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "drink='" + drink + '\'' +
                ", mainCourse='" + mainCourse + '\'' +
                ", side='" + side + '\'' +
                '}';
    }

    public static class Builder {
        private String drink;
        private String mainCourse;
        private String side;

        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Builder setMainCourse(String mainCourse) {
            this.mainCourse = mainCourse;
            return this;
        }

        public Builder setSide(String side) {
            this.side = side;
            return this;
        }
        public Meal buildMeal() {
            return new Meal(this);
        }
    }
}
