package Week1_DesignPatternsAndPrinciples.Ex7_ObserverPatternExample.Code;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("Apple");

        Observer mobile = new MobileApp("iOS App");
        Observer web = new WebApp("Website Dashboard");

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        stockMarket.setStockPrice(150.00);
        stockMarket.setStockPrice(155.50);

        stockMarket.removeObserver(web);

        stockMarket.setStockPrice(160.75);
    }
}

