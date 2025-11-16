package restaurant.factory.Creator;

import restaurant.factory.interfaceFac.MealFactory;

public abstract class Creator {

    public abstract MealFactory createMeal(String type);

    public MealFactory orderMeal(String type) {
        MealFactory meal = createMeal(type);
        System.out.println("Order received: " + meal.getName());
        meal.cook();
        System.out.println("Price: " + meal.getPrice());
        return meal;
    }
}

