package restaurant.decorator.concrete;

import restaurant.decorator.component.Component;
import restaurant.model.Meal;

public class ConcreteComponent implements Component {

    private final Meal meal;

    public ConcreteComponent(Meal meal) {
        this.meal = meal;
    }

    @Override
    public String execute() {
        return meal.getName() + " (price: " + meal.getBasePrice() + ")";
    }
}
