package Week1_DesignPatternsAndPrinciples.Ex2_FactoryMethodPatternExample.Code;

public class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening an Excel document.");
    }
}
