package Week1_DesignPatternsAndPrinciples.Ex4_AdapterPatternExample.Code;

public class Main {
    public static void main(String[] args) {
        // Use PayPal through adapter
        PaymentProcessor paypalProcessor = new PayPalAdapter();
        paypalProcessor.processPayment(250.00);

        // Use Stripe through adapter
        PaymentProcessor stripeProcessor = new StripeAdapter();
        stripeProcessor.processPayment(450.75);
    }
}

