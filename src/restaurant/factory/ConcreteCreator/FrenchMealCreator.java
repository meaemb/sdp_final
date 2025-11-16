package restaurant.factory.ConcreteCreator;

import restaurant.factory.Creator.Creator;
import restaurant.factory.interfaceFac.MealFactory;
import restaurant.factory.impl.*;

import restaurant.factory.Creator.Creator;
import restaurant.factory.interfaceFac.MealFactory;
import restaurant.factory.impl.UniversalMeal;
import restaurant.model.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FrenchMealCreator extends Creator {

    private static final Map<String, Supplier<MealFactory>> frenchMenu = new HashMap<>();

    static {
        Config.FRENCH_MEALS.forEach((key, properties) -> {
            frenchMenu.put(key, () -> new UniversalMeal(properties));
        });
    }

    @Override
    public MealFactory createMeal(String type) {
        Supplier<MealFactory> mealSupplier = frenchMenu.get(type.toLowerCase());
        if (mealSupplier == null) {
            throw new IllegalArgumentException("Unknown French meal: " + type);
        }
        return mealSupplier.get();
    }
}
