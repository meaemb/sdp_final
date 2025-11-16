package restaurant.facade.subsystems;

import restaurant.model.Config;

public class SubsystemPayment {

    public String processPayment(double amount) {
        return Config.MESSAGE_PAYMENT_ACCEPTED + amount;
    }
}
