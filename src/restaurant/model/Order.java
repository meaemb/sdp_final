package restaurant.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Order {
    private final String orderId;
    private final List<OrderItem> items;
    private final String customerName;
    private final String customerPhone;
    private final String deliveryAddress;
    private final Status status;
    private final String specialInstructions;
    private final double totalPrice;

    // Make constructor public so Builder can access it
    public Order(String orderId, List<OrderItem> items, String customerName,
                 String customerPhone, String deliveryAddress, Status status,
                 String specialInstructions, double totalPrice) {
        this.orderId = orderId;
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.deliveryAddress = deliveryAddress;
        this.status = status;
        this.specialInstructions = specialInstructions;
        this.totalPrice = totalPrice;
    }

    // Getters only - immutable object
    public String getOrderId() { return orderId; }
    public List<OrderItem> getItems() { return items; }
    public String getCustomerName() { return customerName; }
    public String getCustomerPhone() { return customerPhone; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public Status getStatus() { return status; }
    public String getSpecialInstructions() { return specialInstructions; }
    public double getTotalPrice() { return totalPrice; }

    public String getOrderSummary() {
        return String.format(
                "Order #%s for %s: %d items, Total: $%.2f, Status: %s",
                orderId, customerName, items.size(), totalPrice, status
        );
    }

    @Override
    public String toString() {
        return String.format(
                "Order{id='%s', customer='%s', items=%d, total=%.2f, status=%s}",
                orderId, customerName, items.size(), totalPrice, status
        );
    }
}