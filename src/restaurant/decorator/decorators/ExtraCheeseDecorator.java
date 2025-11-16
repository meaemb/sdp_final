package restaurant.decorator.decorators;

import restaurant.decorator.base.BaseDecorator;
import restaurant.decorator.component.Component;
import restaurant.model.Config;

public class ExtraCheeseDecorator extends BaseDecorator {

    public ExtraCheeseDecorator(Component wrappee) {
        super(wrappee);
    }

    @Override
    public String execute() {
        return super.execute()
                + " + " + Config.ADDON_CHEESE_LABEL
                + " (+" + Config.ADDON_CHEESE_PRICE + ")";
    }
}
