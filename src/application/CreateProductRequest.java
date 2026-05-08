package application;

import domain.ProductMaterial;
import java.util.List;

public class CreateProductRequest {

    private final String productName;
    private final List<ProductMaterial> materials;

    public CreateProductRequest(String productName,
                                List<ProductMaterial> materials) {
        this.productName = productName;
        this.materials = materials;
    }

    public String getProductName() {
        return productName;
    }

    public List<ProductMaterial> getMaterials() {
        return materials;
    }
}