package Week1_DesignPatternsAndPrinciples.Ex5_DecoratorPatternExample.Code;

public class Main {
    public static void main(String[] args) {
        // Base notifier
        Notifier basicNotifier = new EmailNotifier();

        // Add SMS notifications
        Notifier smsNotifier = new SMSNotifierDecorator(basicNotifier);

        // Add Slack notifications
        Notifier slackAndSmsNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send a notification through all channels
        slackAndSmsNotifier.send("Server is down!");
    }
}

