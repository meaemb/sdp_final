package restaurant.factory.impl;

import restaurant.factory.interfaceFac.MealFactory;
import restaurant.model.Config;

public class UniversalMeal implements MealFactory {
    private final Config.MealProperties properties;

    public UniversalMeal(Config.MealProperties properties) {
        this.properties = properties;
    }

    @Override
    public void cook() {
        System.out.println(properties.getCookingMessage());
    }

    @Override
    public String getName() {
        return properties.getName();
    }

    @Override
    public double getPrice() {
        return properties.getPrice();
    }
}
