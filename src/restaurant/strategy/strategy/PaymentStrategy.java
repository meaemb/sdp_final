package restaurant.strategy.strategy;

public interface PaymentStrategy {

    boolean processPayment(double amount);

    String getPaymentMethod();

    String getTransactionDetails();

    boolean validatePayment();

    String getTransactionId();
}
