

public class ProductResponse {

    private Long id;

    // Declare the name field, representing the name of the product.
    private String name;

    // Declare the price field, representing the price of the product.
    private double price;

    // Declare the stock field, representing the available stock of the product.
    private int stock;

    private String productSerial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProductSerial() {
        return productSerial;
    }

    public void setProductSerial(String productSerial) {
        this.productSerial = productSerial;
    }
}
