package restaurant.builder.config;

public final class BuilderConfig {

    // Limits
    public static final int MAX_ITEMS = 20;
    public static final int MAX_INSTRUCTIONS = 10;

    // Default values
    public static final String DEFAULT_PACKAGING = "Standard";
    public static final String DEFAULT_DIET = "None";

    // Item names for director presets
    public static final String ITEM_SOUP = "Soup";
    public static final String ITEM_BREAD = "Bread";
    public static final String ITEM_SALAD = "Salad";

    // Instructions for presets
    public static final String INSTRUCTION_SERVE_HOT = "Serve hot";
    public static final String INSTRUCTION_NO_ONIONS = "No onions";
    public static final String INSTRUCTION_LOW_CALORIE = "Low calorie";
    public static final String INSTRUCTION_NO_DRESSING = "No dressing";

    // Packaging types
    public static final String PACKAGING_STANDARD = "Standard";
    public static final String PACKAGING_ECO = "Eco";

    // Diet presets
    public static final String DIET_NONE = "None";
    public static final String DIET_VEGAN = "Vegan";

    // Delivery instructions
    public static final String DELIVERY_MAIN_ENTRANCE = "Deliver to the main entrance";
    public static final String DELIVERY_LEAVE_AT_DOOR = "Leave at the door";

    // Gift messages
    public static final String GIFT_HEALTHY_CHOICE = "Healthy choice!";

    // Error messages
    public static final String ERROR_ITEM_LIMIT_EXCEEDED = "Item limit exceeded";

    private BuilderConfig() {
    }
}
