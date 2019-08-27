package homework15.model;

public class Order {

    private String dish;
    private int amount;

    public Order(String dish, int amount) {
        this.dish = dish;
        this.amount = amount;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dish='" + dish + '\'' +
                ", amount=" + amount +
                '}';
    }
}
