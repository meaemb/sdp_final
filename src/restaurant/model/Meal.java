package restaurant.model;

public interface Meal {
    String getName();
    double getBasePrice();
    String getCategory();
    String getDescription();

    default String getFullInfo() {
        return String.format("%s (%s) - $%.2f", getName(), getCategory(), getBasePrice());
    }
}