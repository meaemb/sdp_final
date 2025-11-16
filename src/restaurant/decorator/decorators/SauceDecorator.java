package restaurant.decorator.decorators;

import restaurant.decorator.base.BaseDecorator;
import restaurant.decorator.component.Component;
import restaurant.model.Config;

public class SauceDecorator extends BaseDecorator {

    public SauceDecorator(Component wrappee) {
        super(wrappee);
    }

    @Override
    public String execute() {
        return super.execute()
                + " + " + Config.ADDON_SAUCE_LABEL
                + " (+" + Config.ADDON_SAUCE_PRICE + ")";
    }
}
