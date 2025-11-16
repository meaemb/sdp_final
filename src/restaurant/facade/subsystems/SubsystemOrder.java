package restaurant.facade.subsystems;

import restaurant.model.Config;

public class SubsystemOrder {

    public String processOrder(String dish) {
        return Config.MESSAGE_ORDER_PROCESSED + dish;
    }
}
