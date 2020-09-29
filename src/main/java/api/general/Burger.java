package api.general;

import java.util.List;

public class Burger implements FoodProduct {

    String name;
    List<FoodProduct> items;

    public Burger(String name, List<FoodProduct> items) {
        this.name = name;
        this.items = items;
    }

    @Override
    public double calories_per_100g() {
        return calories() / weight() *100;
    }


    @Override
    public double weight() {
        return items.stream().map(Product::weight).reduce(0.0, Double::sum);
    }

    @Override
    public double price() {
        return items.stream().map(Product::price).reduce(0.0, Double::sum);
    }

    @Override
    public double calories() {
        return items.stream().map(FoodProduct::calories).reduce(0.0, Double::sum);
    }

    @Override
    public String toString() {
        final String DELIM = "--------------------\n";
        StringBuilder buffer = new StringBuilder();
        buffer.append(String.format("*** Menu %s ***\n", name));
        for (Object item : items) {
            buffer.append(String.format("- %s\n", item));
        }
        buffer.append(DELIM);
        buffer.append(String.format("price:         %.2f\n", price()));
        buffer.append(DELIM);
       buffer.append(String.format("calories        %.2f\n", calories()));
        buffer.append(DELIM);
        return buffer.toString();
    }


}
