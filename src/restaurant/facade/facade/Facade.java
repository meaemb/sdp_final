package restaurant.facade.facade;

import restaurant.facade.subsystems.*;

public class Facade {

    private final SubsystemOrder order;
    private final SubsystemPayment payment;
    private final SubsystemDelivery delivery;
    private final SubsystemInventory inventory;

    public Facade() {
        this.order = new SubsystemOrder();
        this.payment = new SubsystemPayment();
        this.delivery = new SubsystemDelivery();
        this.inventory = new SubsystemInventory();
    }

    public void subsystemOperation(String dish, double amount, String address) {
        System.out.println(order.processOrder(dish));
        System.out.println(payment.processPayment(amount));
        System.out.println(inventory.checkInventory());
        System.out.println(delivery.deliver(address));
    }
}
