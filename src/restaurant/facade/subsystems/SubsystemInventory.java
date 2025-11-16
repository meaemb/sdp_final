package restaurant.facade.subsystems;

import restaurant.model.Config;

public class SubsystemInventory {

    public String checkInventory() {
        return Config.MESSAGE_INVENTORY_OK;
    }
}
