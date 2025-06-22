package Week1_AlgorithmsAndDataStructures.Ex7_FinancialForecasting.Code;

public class FinancialForecasting {

    // Recursive method
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double annualGrowthRate = 0.05; // 5%
        int years = 10;

        double futureValue = predictFutureValue(initialValue, annualGrowthRate, years);
        System.out.println("Future Value after " + years + " years: $" + futureValue);
    }
}

