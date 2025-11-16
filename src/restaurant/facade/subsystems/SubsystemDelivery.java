package restaurant.facade.subsystems;

import restaurant.model.Config;

public class SubsystemDelivery {

    public String deliver(String address) {
        return Config.MESSAGE_DELIVERY_STARTED + address;
    }
}
