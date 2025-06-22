package Week1_AlgorithmsAndDataStructures.Ex3_SortingCustomerOrders.Code;

public class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {


        return "Order \n" +
           "  orderId='" + orderId + "'\n" +
           "  customerName='" +customerName + "'\n" +
           "  totalPrice=" + totalPrice + '\n';
        //    '}';
    }
}

