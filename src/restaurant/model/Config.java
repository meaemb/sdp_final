package restaurant.model;

import java.util.Map;

public class Config {
    // Decorator labels
    public static final String ADDON_CHEESE_LABEL = "Extra Cheese";
    public static final double ADDON_CHEESE_PRICE = 500;

    public static final String ADDON_SAUCE_LABEL = "Special Sauce";
    public static final double ADDON_SAUCE_PRICE = 300;

    // Facade messages
    public static final String MESSAGE_ORDER_PROCESSED = "Order processed: ";
    public static final String MESSAGE_PAYMENT_ACCEPTED = "Payment accepted: ";
    public static final String MESSAGE_DELIVERY_STARTED = "Delivery started to: ";
    public static final String MESSAGE_INVENTORY_OK = "Inventory checked: available";

    public static final String MESSAGE_ADDITIONAL_FACADE = "Additional facade operation executed.";

    // OBSERVER MESSAGES
    public static final String MESSAGE_KITCHEN_UPDATE = "Kitchen: updating order state → %s";
    public static final String MESSAGE_COURIER_UPDATE = "Courier %s: preparing for → %s";
    public static final String MESSAGE_MANAGER_UPDATE = "Manager: Checking status → %s";
    public static final String MESSAGE_WAITER_UPDATE = "Waiter %s: received update → %s";

    // OBSERVER ROLES
    public static final String ROLE_COURIER = "Courier";
    public static final String ROLE_MANAGER = "Manager";
    public static final String ROLE_WAITER = "Waiter";
    public static final String ROLE_KITCHEN = "Kitchen";

    // Restaurant configuration
    public static final String RESTAURANT_NAME = "Le Restaurant Français";
    public static final String DEFAULT_ADDRESS = "Paris, Champs-Élysées";

    // Payment configuration
    public static final double SERVICE_CHARGE = 200;
    public static final double TAX_RATE = 0.1;

    public static final Map<String, MealProperties> FRENCH_MEALS = Map.of(
            "bouillabaisse", new MealProperties("Bouillabaisse", 5500, "Cooking Bouillabaisse (French seafood soup)..."),
            "cremebrulee", new MealProperties("Creme Brulee", 1500, "Caramelizing sugar on top of Crème Brûlée..."),
            "croissant", new MealProperties("Croissant", 900, "Baking Croissant (buttery French pastry)..."),
            "ratatouille", new MealProperties("Ratatouille", 3500, "Cooking Ratatouille (French vegetable stew)..."),
            "quiche", new MealProperties("Quiche Lorraine", 2200, "Baking Quiche Lorraine (eggs, cheese, bacon)...")
    );

    public static class MealProperties {
        private final String name;
        private final double price;
        private final String cookingMessage;

        public MealProperties(String name, double price, String cookingMessage) {
            this.name = name;
            this.price = price;
            this.cookingMessage = cookingMessage;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getCookingMessage() { return cookingMessage; }
    }
}
