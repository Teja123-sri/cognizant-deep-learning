package Week1_AlgorithmsAndDataStructures.Ex1_InventoryManagementSystem.Code;
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding Products
        inventory.addProduct(new Product("P1", "Laptop", 10, 50000.0));
        inventory.addProduct(new Product("P2", "Smartphone", 25, 20000.0));

        System.out.println("\nInitial Products:");
        inventory.listProducts();

        // Updating Product
        inventory.updateProduct("P2", 30, 18000.0);

        // Deleting Product
        inventory.deleteProduct("P1");

        System.out.println("\nFinal Products:");
        inventory.listProducts();
    }
}
