package Week1_AlgorithmsAndDataStructures.Ex1_InventoryManagementSystem.Code;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Add Product
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Update Product
    public void updateProduct(String productId, int quantity, double price) {
        Product p = products.get(productId);
        if (p != null) {
            p.setQuantity(quantity);
            p.setPrice(price);
            System.out.println("Updated Product: " + p);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Delete Product
    public void deleteProduct(String productId) {
        if (products.remove(productId) != null) {
            System.out.println("Product with ID " + productId + " deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // List All Products
    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            products.values().forEach(System.out::println);
        }
    }
}

