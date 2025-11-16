package restaurant.strategy.concretestrategies;

import restaurant.strategy.strategy.PaymentStrategy;

public class CashPayment implements PaymentStrategy {

    private final double amountTendered;
    private String transactionId;
    private boolean paymentProcessed = false;

    public CashPayment(double amountTendered) {
        if (amountTendered < 0) {
            throw new IllegalArgumentException("Amount tendered cannot be negative");
        }
        this.amountTendered = amountTendered;
    }

    @Override
    public boolean processPayment(double amount) {
        if (!validatePayment()) return false;

        if (amountTendered >= amount) {
            double change = amountTendered - amount;

            this.transactionId = "CASH-" + System.currentTimeMillis();
            this.paymentProcessed = true;

            if (change == 0) {
                System.out.println("Cash payment received. Exact amount.");
            } else {
                System.out.printf("Cash payment received. Change: %.2f₸%n", change);
            }
            return true;
        }

        System.out.printf("Insufficient cash. Required: %.2f, Provided: %.2f₸%n",
                amount, amountTendered);
        return false;
    }

    @Override
    public boolean validatePayment() {
        return amountTendered > 0;
    }

    @Override
    public String getPaymentMethod() {
        return "Cash";
    }

    @Override
    public String getTransactionDetails() {
        return paymentProcessed
                ? String.format("Cash Payment - Amount: %.2f₸, Transaction: %s",
                amountTendered, transactionId)
                : "Cash Payment - Not Processed";
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }
}
