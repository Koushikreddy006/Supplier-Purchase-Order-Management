
public class Product {

    private int productId;
    private String productName;
    private double price;
    private int stockQuantity;

    // Constructor
    public Product(int productId, String productName,
                   double price, int stockQuantity) {

        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getter methods
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // Display product details
    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Stock Quantity: " + stockQuantity);
    }
}
