package restaurant.strategy.concretestrategies;

import restaurant.strategy.strategy.PaymentStrategy;

import java.util.UUID;

public class OnlineWalletPayment implements PaymentStrategy {

    private final String walletType;
    private final String email;
    private final String walletId;

    private String transactionId;
    private boolean paymentProcessed = false;

    public OnlineWalletPayment(String walletType, String email, String walletId) {

        if (walletType == null || walletType.trim().isEmpty())
            throw new IllegalArgumentException("Wallet type cannot be empty");

        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new IllegalArgumentException("Invalid email format");

        this.walletType = walletType;
        this.email = email;
        this.walletId = "****" + walletId.substring(walletId.length() - 4);
    }

    @Override
    public boolean processPayment(double amount) {
        if (!validatePayment()) return false;

        System.out.printf("Processing %s payment of %.2f₸ for %s%n",
                walletType, amount, email);

        boolean approved = Math.random() > 0.05;

        if (approved) {
            this.transactionId = "WLT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            this.paymentProcessed = true;

            System.out.printf(" %s payment processed successfully%n", walletType);
            return true;
        }

        System.out.printf("%s payment failed%n", walletType);
        return false;
    }

    @Override
    public boolean validatePayment() {
        return email != null && walletType != null;
    }

    @Override
    public String getPaymentMethod() {
        return walletType + " Wallet";
    }

    @Override
    public String getTransactionDetails() {
        return paymentProcessed
                ? String.format("%s Payment - Email: %s, Wallet: %s, Transaction: %s",
                walletType, email, walletId, transactionId)
                : walletType + " Payment - Not Processed";
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }
}
