package Week1_DesignPatternsAndPrinciples.Ex7_ObserverPatternExample.Code;

public interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

