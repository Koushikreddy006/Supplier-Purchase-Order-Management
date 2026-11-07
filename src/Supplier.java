
public class Supplier {

    private int supplierId;
    private String supplierName;
    private String email;
    private String phone;
    private String city;

    // Constructor
    public Supplier(int supplierId, String supplierName,
                    String email, String phone, String city) {

        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.email = email;
        this.phone = phone;
        this.city = city;
    }

    // Getter method
    public int getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    // Display supplier details
    public void displaySupplier() {
        System.out.println("Supplier ID: " + supplierId);
        System.out.println("Supplier Name: " + supplierName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("City: " + city);
    }
}
