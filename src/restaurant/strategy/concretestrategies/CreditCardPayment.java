package restaurant.strategy.concretestrategies;

import restaurant.strategy.strategy.PaymentStrategy;

import java.util.UUID;

public class CreditCardPayment implements PaymentStrategy {

    private final String cardNumber;
    private final String cardHolder;
    private final String expiryDate;

    private String transactionId;
    private boolean paymentProcessed = false;

    public CreditCardPayment(String cardNumber, String cardHolder, String expiryDate, String cvv) {

        if (!cardNumber.matches("\\d{13,19}"))
            throw new IllegalArgumentException("Invalid card number format");

        if (!expiryDate.matches("(0[1-9]|1[0-2])/[0-9]{2}"))
            throw new IllegalArgumentException("Invalid expiry date format");

        if (!cvv.matches("\\d{3,4}"))
            throw new IllegalArgumentException("Invalid CVV format");

        this.cardNumber = "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean processPayment(double amount) {
        if (!validatePayment()) return false;

        System.out.printf("Processing credit card payment of %.2f₸ for %s%n",
                amount, cardHolder);

        boolean approved = Math.random() > 0.1;

        if (approved) {
            this.transactionId = "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            this.paymentProcessed = true;
            System.out.println("Credit card payment processed successfully");
            return true;
        }

        System.out.println("Credit card payment declined.");
        return false;
    }

    @Override
    public boolean validatePayment() {
        return cardHolder != null && !cardHolder.isEmpty();
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }

    @Override
    public String getTransactionDetails() {
        return paymentProcessed
                ? String.format("Credit Card Payment - Card: %s, Holder: %s, Transaction: %s",
                cardNumber, cardHolder, transactionId)
                : "Credit Card Payment - Not Processed";
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }
}
