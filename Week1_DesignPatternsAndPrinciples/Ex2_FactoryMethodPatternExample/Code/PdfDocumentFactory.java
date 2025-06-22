package Week1_DesignPatternsAndPrinciples.Ex2_FactoryMethodPatternExample.Code;

public class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}