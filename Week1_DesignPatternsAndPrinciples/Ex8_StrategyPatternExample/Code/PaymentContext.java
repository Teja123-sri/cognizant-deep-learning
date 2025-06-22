package Week1_DesignPatternsAndPrinciples.Ex8_StrategyPatternExample.Code;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void payAmount(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Payment method not selected!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

