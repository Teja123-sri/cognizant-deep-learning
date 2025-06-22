package Week1_DesignPatternsAndPrinciples.Ex2_FactoryMethodPatternExample.Code;

public class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}
