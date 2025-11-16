package restaurant.model;

public class OrderItem {
    private final String mealName;
    private final int quantity;
    private final double unitPrice;

    public OrderItem(String mealName, int quantity, double unitPrice) {
        if (mealName == null || mealName.trim().isEmpty()) {
            throw new IllegalArgumentException("Meal name cannot be null or empty");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative");
        }

        this.mealName = mealName.trim();
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getMealName() { return mealName; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }
    public double getTotalPrice() { return unitPrice * quantity; }

    @Override
    public String toString() {
        return String.format(
                "OrderItem{meal='%s', quantity=%d, unitPrice=%.2f, total=%.2f}",
                mealName, quantity, unitPrice, getTotalPrice()
        );
    }
}
