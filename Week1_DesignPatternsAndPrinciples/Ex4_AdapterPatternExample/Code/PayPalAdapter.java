package Week1_DesignPatternsAndPrinciples.Ex4_AdapterPatternExample.Code;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypalGateway;

    public PayPalAdapter() {
        this.paypalGateway = new PayPalGateway();
    }

    @Override
    public void processPayment(double amount) {
        paypalGateway.sendPayment(amount);
    }
}

