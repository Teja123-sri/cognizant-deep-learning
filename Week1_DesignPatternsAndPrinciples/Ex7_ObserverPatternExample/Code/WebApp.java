package Week1_DesignPatternsAndPrinciples.Ex7_ObserverPatternExample.Code;

public class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(appName + " received update: " + stockName + " is now $" + price);
    }
}

