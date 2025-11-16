package restaurant.decorator.base;

import restaurant.decorator.component.Component;

public abstract class BaseDecorator implements Component {

    protected final Component wrappee;

    protected BaseDecorator(Component wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String execute() {
        return wrappee.execute();
    }
}
