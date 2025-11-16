package restaurant.builder.products;

import restaurant.builder.config.BuilderConfig;

import java.util.ArrayList;
import java.util.List;

public class ComplexOrder {

    private String customerName;
    private final List<String> items = new ArrayList<>();
    private final List<String> specialInstructions = new ArrayList<>();

    private boolean requiresCutlery;
    private boolean isGift;
    private String giftMessage;
    private String packagingType;
    private String dietaryPreference;
    private String deliveryInstructions;

    public ComplexOrder() {
        this.requiresCutlery = false;
        this.isGift = false;
        this.giftMessage = "";
        this.packagingType = BuilderConfig.DEFAULT_PACKAGING;
        this.dietaryPreference = BuilderConfig.DEFAULT_DIET;
        this.deliveryInstructions = "";
    }

    // SETTERS
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void addItem(String item) {
        this.items.add(item);
    }

    public void addInstruction(String instruction) {
        this.specialInstructions.add(instruction);
    }

    public void setRequiresCutlery(boolean value) {
        this.requiresCutlery = value;
    }

    public void setGift(boolean value) {
        this.isGift = value;
    }

    public void setGiftMessage(String msg) {
        this.giftMessage = msg;
    }

    public void setPackagingType(String type) {
        this.packagingType = type;
    }

    public void setDietaryPreference(String pref) {
        this.dietaryPreference = pref;
    }

    public void setDeliveryInstructions(String instr) {
        this.deliveryInstructions = instr;
    }

    // Needed by builder (for size checks)
    public List<String> getItems() {
        return items;
    }

    public String summary() {
        return "Order Summary:\n" +
                "Customer: " + customerName + "\n" +
                "Items: " + items + "\n" +
                "Instructions: " + specialInstructions + "\n" +
                "Cutlery: " + requiresCutlery + "\n" +
                "Gift: " + isGift + (isGift ? " (" + giftMessage + ")" : "") + "\n" +
                "Packaging: " + packagingType + "\n" +
                "Diet: " + dietaryPreference + "\n" +
                "Delivery: " + deliveryInstructions;
    }
}
