package restaurant.builder.builder;

import restaurant.builder.products.ComplexOrder;

public interface OrderBuilder {

    OrderBuilder setCustomer(String name);

    OrderBuilder addItem(String item);

    OrderBuilder addInstruction(String instruction);

    OrderBuilder setPackaging(String type);

    OrderBuilder setCutlery(boolean value);

    OrderBuilder setGift(boolean value, String message);

    OrderBuilder setDiet(String preference);

    OrderBuilder setDeliveryInstructions(String instructions);

    ComplexOrder build();

    void reset();
}
