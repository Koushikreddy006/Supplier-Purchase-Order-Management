
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    static ArrayList<Supplier> suppliers = new ArrayList<>();
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<PurchaseOrder> orders = new ArrayList<>();
    static ArrayList<OrderItem> items = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== SUPPLIER MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Supplier");
            System.out.println("2. View Suppliers");
            System.out.println("3. Add Product");
            System.out.println("4. View Products");
            System.out.println("5. Create Purchase Order");
            System.out.println("6. View Purchase Orders");
            System.out.println("7. Calculate Order Total");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addSupplier();
                    break;

                case 2:
                    viewSuppliers();
                    break;

                case 3:
                    addProduct();
                    break;

                case 4:
                    viewProducts();
                    break;

                case 5:
                    createPurchaseOrder();
                    break;

                case 6:
                    viewPurchaseOrders();
                    break;

                case 7:
                    calculateOrderTotal();
                    break;

                case 8:
                    System.out.println("Thank you for using the application!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }

    // Add Supplier
    static void addSupplier() {

        int id = suppliers.size() + 1;

        System.out.print("Enter supplier name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter city: ");
        String city = sc.nextLine();

        Supplier s = new Supplier(id, name, email, phone, city);

        suppliers.add(s);

        System.out.println("Supplier added successfully!");
    }

    // View Suppliers
    static void viewSuppliers() {

        if (suppliers.isEmpty()) {
            System.out.println("No suppliers available.");
            return;
        }

        for (Supplier s : suppliers) {
            s.displaySupplier();
            System.out.println("--------------------");
        }
    }

    // Add Product
    static void addProduct() {

        int id = products.size() + 1;

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter stock quantity: ");
        int stock = sc.nextInt();

        Product p = new Product(id, name, price, stock);

        products.add(p);

        System.out.println("Product added successfully!");
    }

    // View Products
    static void viewProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : products) {
            p.displayProduct();
            System.out.println("--------------------");
        }
    }

    // Create Purchase Order
    static void createPurchaseOrder() {

        if (suppliers.isEmpty() || products.isEmpty()) {
            System.out.println("Add suppliers and products first!");
            return;
        }

        System.out.print("Enter supplier ID: ");
        int supplierId = sc.nextInt();

        Supplier selectedSupplier = null;

        for (Supplier s : suppliers) {
            if (s.getSupplierId() == supplierId) {
                selectedSupplier = s;
                break;
            }
        }

        if (selectedSupplier == null) {
            System.out.println("Supplier not found!");
            return;
        }

        System.out.print("Enter product ID: ");
        int productId = sc.nextInt();

        Product selectedProduct = null;

        for (Product p : products) {
            if (p.getProductId() == productId) {
                selectedProduct = p;
                break;
            }
        }

        if (selectedProduct == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        if (quantity <= 0 || quantity > selectedProduct.getStockQuantity()) {
            System.out.println("Invalid quantity or insufficient stock!");
            return;
        }

        int orderId = orders.size() + 1;
        int itemId = items.size() + 1;

        PurchaseOrder po = new PurchaseOrder(
            orderId,
            supplierId,
            LocalDate.now().toString(),
            "Pending"
        );

        OrderItem item = new OrderItem(
            itemId,
            orderId,
            productId,
            quantity,
            selectedProduct.getPrice()
        );

        orders.add(po);
        items.add(item);

        System.out.println("Purchase order created successfully!");
        System.out.println("Order ID: " + orderId);
        System.out.println("Supplier: " + selectedSupplier.getSupplierName());
    }

    // View Purchase Orders
    static void viewPurchaseOrders() {

        if (orders.isEmpty()) {
            System.out.println("No purchase orders available.");
            return;
        }

        for (PurchaseOrder po : orders) {

            po.displayOrder();

            System.out.println("Order Items:");

            for (OrderItem item : items) {

                if (item.getOrderId() == po.getOrderId()) {
                    item.displayOrderItem();
                }
            }

            System.out.println("--------------------");
        }
    }

    // Calculate Order Total
    static void calculateOrderTotal() {

        System.out.print("Enter order ID: ");
        int orderId = sc.nextInt();

        double total = 0;
        boolean found = false;

        for (OrderItem item : items) {

            if (item.getOrderId() == orderId) {
                total += item.calculateTotal();
                found = true;
            }
        }

        if (found) {
            System.out.println("Total Purchase Amount: " + total);
        } else {
            System.out.println("Order not found!");
        }
    }
}
