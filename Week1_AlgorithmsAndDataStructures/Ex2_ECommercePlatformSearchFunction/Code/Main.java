// package Algorithms_dataStructures.ECommercePlatformSearchFunction;
package Week1_AlgorithmsAndDataStructures.Ex2_ECommercePlatformSearchFunction.Code;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P1", "Laptop", "Electronics"),
            new Product("P2", "Phone", "Electronics"),
            new Product("P3", "Keyboard", "Accessories"),
            new Product("P4", "Mouse", "Accessories")
        };
        
        // Linear Search
        System.out.println("\nLinear Search for P3:");
        Product found1 = Search.linearSearch(products, "P3");
        System.out.println(found1);

        // Binary Search
        Arrays.sort(products, Comparator.comparing(Product::getProductId));

        System.out.println("\nBinary Search for P3:");
        Product found2 = Search.binarySearch(products, "P3");
        System.out.println(found2);
    }
}

