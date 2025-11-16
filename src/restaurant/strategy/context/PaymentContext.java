package restaurant.strategy.context;

import restaurant.strategy.strategy.PaymentStrategy;

public class PaymentContext {

    private PaymentStrategy paymentStrategy;
    private final String orderId;
    private final double amount;

    public PaymentContext(String orderId, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (orderId == null || orderId.isEmpty())
            throw new IllegalArgumentException("Order ID cannot be empty");

        this.orderId = orderId;
        this.amount = amount;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        if (strategy == null)
            throw new IllegalArgumentException("Payment strategy cannot be null");
        this.paymentStrategy = strategy;
    }

    public boolean executePayment() {
        if (paymentStrategy == null)
            throw new IllegalStateException("Payment strategy not set");

        System.out.printf("Initiating payment for Order %s: %.2f₸%n",
                orderId, amount);

        boolean success = paymentStrategy.processPayment(amount);

        if (success) {
            System.out.printf("Payment completed for Order %s%n", orderId);
            System.out.println("Transaction Details: " +
                    paymentStrategy.getTransactionDetails());
        } else {
            System.out.printf("Payment failed for Order %s%n", orderId);
        }

        return success;
    }
}
