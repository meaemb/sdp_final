package restaurant.strategy.context;

import restaurant.strategy.strategy.PaymentStrategy;
import restaurant.strategy.concretestrategies.CashPayment;
import restaurant.strategy.concretestrategies.CreditCardPayment;
import restaurant.strategy.concretestrategies.OnlineWalletPayment;

import java.util.HashMap;
import java.util.Map;

public class PaymentProcessor {

    private final Map<String, PaymentContext> sessions = new HashMap<>();

    public PaymentContext createPaymentSession(String orderId, double amount) {
        PaymentContext ctx = new PaymentContext(orderId, amount);
        sessions.put(orderId, ctx);
        return ctx;
    }

    public PaymentStrategy createCreditCardStrategy(
            String number, String holder, String expiry, String cvv
    ) {
        return new CreditCardPayment(number, holder, expiry, cvv);
    }

    public PaymentStrategy createCashStrategy(double cashGiven) {
        return new CashPayment(cashGiven);
    }

    public PaymentStrategy createOnlineWalletStrategy(String type, String email, String id) {
        return new OnlineWalletPayment(type, email, id);
    }

    public boolean processPayment(String orderId, PaymentStrategy strategy) {
        PaymentContext ctx = sessions.get(orderId);
        if (ctx == null) {
            System.out.println("No payment session found for " + orderId);
            return false;
        }

        ctx.setPaymentStrategy(strategy);
        return ctx.executePayment();
    }
}
