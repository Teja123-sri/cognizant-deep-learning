package Week1_DesignPatternsAndPrinciples.Ex8_StrategyPatternExample.Code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose payment method (1. Credit Card, 2. PayPal): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "Alice"));
                break;
            case 2:
                context.setPaymentStrategy(new PayPalPayment("alice@example.com"));
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();

        context.payAmount(amount);
        scanner.close();
    }
}

