package restaurant.builder.builder;

import restaurant.builder.config.BuilderConfig;
import restaurant.builder.products.ComplexOrder;

public class ComplexOrderBuilder implements OrderBuilder {

    private ComplexOrder order;

    public ComplexOrderBuilder() {
        reset();
    }

    @Override
    public void reset() {
        this.order = new ComplexOrder();
    }

    @Override
    public OrderBuilder setCustomer(String name) {
        order.setCustomerName(name);
        return this;
    }

    @Override
    public OrderBuilder addItem(String item) {
        if (order.getItems().size() >= BuilderConfig.MAX_ITEMS) {
            throw new IllegalStateException(BuilderConfig.ERROR_ITEM_LIMIT_EXCEEDED);
        }
        order.addItem(item);
        return this;
    }

    @Override
    public OrderBuilder addInstruction(String instruction) {
        order.addInstruction(instruction);
        return this;
    }

    @Override
    public OrderBuilder setPackaging(String type) {
        order.setPackagingType(type);
        return this;
    }

    @Override
    public OrderBuilder setCutlery(boolean value) {
        order.setRequiresCutlery(value);
        return this;
    }

    @Override
    public OrderBuilder setGift(boolean value, String message) {
        order.setGift(value);
        if (value) {
            order.setGiftMessage(message);
        }
        return this;
    }

    @Override
    public OrderBuilder setDiet(String preference) {
        order.setDietaryPreference(preference);
        return this;
    }

    @Override
    public OrderBuilder setDeliveryInstructions(String instructions) {
        order.setDeliveryInstructions(instructions);
        return this;
    }

    @Override
    public ComplexOrder build() {
        ComplexOrder result = this.order;
        reset();
        return result;
    }
}
