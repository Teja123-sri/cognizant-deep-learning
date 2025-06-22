// package Week1_AlgorithmsAndDataStructures.ECommercePlatformSearchFunction;

// package Algorithms_dataStructures.ECommercePlatformSearchFunction;
package Week1_AlgorithmsAndDataStructures.Ex2_ECommercePlatformSearchFunction.Code;
public class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Product {\n" +
           "  productId='" + productId + "'\n" +
           "  productName='" + productName + "'\n" +
           "  category=" + category + '\n' +
           '}';
    }
}

