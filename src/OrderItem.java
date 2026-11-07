
public class OrderItem {

    private int itemId;
    private int orderId;
    private int productId;
    private int quantity;
    private double unitPrice;

    // Constructor
    public OrderItem(int itemId, int orderId,
                     int productId, int quantity,
                     double unitPrice) {

        this.itemId = itemId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getter methods
    public int getItemId() {
        return itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    // Calculate total price
    public double calculateTotal() {
        return quantity * unitPrice;
    }

    // Display order item
    public void displayOrderItem() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Order ID: " + orderId);
        System.out.println("Product ID: " + productId);
        System.out.println("Quantity: " + quantity);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Total: " + calculateTotal());
    }
}
