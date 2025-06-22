package Week1_AlgorithmsAndDataStructures.Ex3_SortingCustomerOrders.Code;

public class Main {
    public static void main(String[] args) {
        // 1️ Create sample orders
        Order[] orders = {
            new Order("O101", "Alice", 250.75),
            new Order("O102", "Bob", 100.40),
            new Order("O103", "Carol", 500.90),
            new Order("O104", "David", 300.25),
        };
        
        // 2️ Test Bubble Sort
        Order[] bubbleSorted = orders.clone();
        Sort.bubbleSort(bubbleSorted);
        System.out.println("\nBUBBLE SORT:");
        for (Order order : bubbleSorted) {
            System.out.println(order);
        }

        // 3️ Test Quick Sort
        Order[] quickSorted = orders.clone();
        Sort.quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("\nQUICK SORT:");
        for (Order order : quickSorted) {
            System.out.println(order);
        }
    }
}

