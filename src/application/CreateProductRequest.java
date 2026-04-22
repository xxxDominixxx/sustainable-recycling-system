package application;

public class CreateProductRequest {
    private String productName;
    private String productCategory;
    private int estimatedLifespan;

    public CreateProductRequest(String productName, String productCategory, int estimatedLifespan) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.estimatedLifespan = estimatedLifespan;
    }
    public String getProductName() {
        return productName;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public int getEstimatedLifespan() {
        return estimatedLifespan;
    }
}
