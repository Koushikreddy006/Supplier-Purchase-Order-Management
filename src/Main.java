
public class Main {

    public static void main(String[] args) {

        // Create Supplier object
        Supplier s = new Supplier(
            1,
            "Dell",
            "dell@example.com",
            "9876543210",
            "Pune"
        );

        // Create Product object
        Product p = new Product(
            1,
            "Laptop",
            50000,
            20
        );

        // Create PurchaseOrder object
        PurchaseOrder po = new PurchaseOrder(
            1001,
            1,
            "2026-11-07",
            "Pending"
        );

        // Create OrderItem object
        OrderItem item = new OrderItem(
            1,
            1001,
            1,
            10,
            50000
        );

        // Display supplier details
        System.out.println("===== SUPPLIER DETAILS =====");
        s.displaySupplier();

        // Display product details
        System.out.println("\n===== PRODUCT DETAILS =====");
        p.displayProduct();

        // Display purchase order
        System.out.println("\n===== PURCHASE ORDER =====");
        po.displayOrder();

        // Display order item
        System.out.println("\n===== ORDER ITEM =====");
        item.displayOrderItem();

        // Display total purchase amount
        System.out.println("\n===== TOTAL AMOUNT =====");
        System.out.println(item.calculateTotal());
    }
}
