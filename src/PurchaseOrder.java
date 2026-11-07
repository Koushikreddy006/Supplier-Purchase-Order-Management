
public class PurchaseOrder {

    private int orderId;
    private int supplierId;
    private String orderDate;
    private String status;

    // Constructor
    public PurchaseOrder(int orderId, int supplierId,
                         String orderDate, String status) {

        this.orderId = orderId;
        this.supplierId = supplierId;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getter methods
    public int getOrderId() {
        return orderId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    // Display order details
    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Supplier ID: " + supplierId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + status);
    }
}
