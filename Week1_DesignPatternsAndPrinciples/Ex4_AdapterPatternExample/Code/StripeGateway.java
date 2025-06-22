package Week1_DesignPatternsAndPrinciples.Ex4_AdapterPatternExample.Code;

public class StripeGateway {
    public void makeStripePayment(double amount) {
        System.out.println("Payment of $" + amount + " processed via Stripe.");
    }
}

