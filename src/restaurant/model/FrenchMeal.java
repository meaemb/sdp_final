package restaurant.model;

public class FrenchMeal implements Meal {
    private final String name;
    private final double basePrice;
    private final String category;
    private final String description;

    public FrenchMeal(String name, double basePrice, String category, String description) {
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getFullInfo() {
        return String.format("%s - %s ($%.2f)\n   %s", name, category, basePrice, description);
    }
}