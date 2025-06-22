package Week1_DesignPatternsAndPrinciples.Ex5_DecoratorPatternExample.Code;

public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

