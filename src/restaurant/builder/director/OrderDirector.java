package restaurant.builder.director;

import restaurant.builder.builder.OrderBuilder;
import restaurant.builder.config.BuilderConfig;
import restaurant.builder.products.ComplexOrder;

public class OrderDirector {

    private OrderBuilder builder;

    public OrderDirector(OrderBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(OrderBuilder builder) {
        this.builder = builder;
    }

    public ComplexOrder createStandardOrder(String customer) {
        return builder
                .setCustomer(customer)
                .addItem(BuilderConfig.ITEM_SOUP)
                .addItem(BuilderConfig.ITEM_BREAD)
                .addInstruction(BuilderConfig.INSTRUCTION_SERVE_HOT)
                .addInstruction(BuilderConfig.INSTRUCTION_NO_ONIONS)
                .setPackaging(BuilderConfig.PACKAGING_STANDARD)
                .setCutlery(true)
                .setGift(false, "")
                .setDiet(BuilderConfig.DIET_NONE)
                .setDeliveryInstructions(BuilderConfig.DELIVERY_MAIN_ENTRANCE)
                .build();
    }

    public ComplexOrder createDietOrder(String customer) {
        return builder
                .setCustomer(customer)
                .addItem(BuilderConfig.ITEM_SALAD)
                .addInstruction(BuilderConfig.INSTRUCTION_LOW_CALORIE)
                .addInstruction(BuilderConfig.INSTRUCTION_NO_DRESSING)
                .setDiet(BuilderConfig.DIET_VEGAN)
                .setPackaging(BuilderConfig.PACKAGING_ECO)
                .setCutlery(false)
                .setGift(true, BuilderConfig.GIFT_HEALTHY_CHOICE)
                .setDeliveryInstructions(BuilderConfig.DELIVERY_LEAVE_AT_DOOR)
                .build();
    }
}
