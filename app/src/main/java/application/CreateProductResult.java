package application;

public class CreateProductResult {
    private String productType;

    public CreateProductResult(String productName) {
        this.productType = productName;
    }
    public String getProductName() {
        return productType;
    }

}
