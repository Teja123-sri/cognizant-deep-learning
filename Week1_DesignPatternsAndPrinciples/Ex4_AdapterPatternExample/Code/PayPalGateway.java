package Week1_DesignPatternsAndPrinciples.Ex4_AdapterPatternExample.Code;

public class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Payment of $" + amount + " processed via PayPal.");
    }
}

