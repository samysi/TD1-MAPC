package api.general;

public class DeepFriedOnions implements FoodProduct {
    // 590 kcal / 100g

    private double weight;
    private double BASE_PRICE = 1.5;

    public DeepFriedOnions(double weight) {
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double price() {
        return BASE_PRICE * weight / 100;
    }

    @Override
    public String toString() {
        return String.format("deep fried onions (%.0fg) -- %.2f€", weight(), price());
    }

    @Override
    public double calories_per_100g() {
        return 590;
    }
}
