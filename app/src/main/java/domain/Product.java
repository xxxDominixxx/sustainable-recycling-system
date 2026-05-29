package domain;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String productType;
    private RecyclingCategory recyclingCategory;
    private int estimatedLifespan;
    private double calculatedImpact;

    private List<ProductMaterial> materials;

    public Product(String productName,
                   RecyclingCategory recyclingCategory,
                   int estimatedLifespan) {

        this.productType = productName;
        this.recyclingCategory = recyclingCategory;
        this.estimatedLifespan = estimatedLifespan;
        this.materials = new ArrayList<>();
    }

    // MATERIALS
    public void addMaterial(ProductMaterial productMaterial) {
        materials.add(productMaterial);
    }

    // GETTERS
    public String getProductType() {
        return productType;
    }

    public RecyclingCategory getRecyclingCategory() {
        return recyclingCategory;
    }

    public int getEstimatedLifespan() {
        return estimatedLifespan;
    }

    public List<ProductMaterial> getMaterials() {
        return materials;
    }

    public double getCalculatedImpact() {
        return calculatedImpact;
    }

    // SETTERS (THIS FIXES YOUR ERROR)
    public void setRecyclingCategory(RecyclingCategory recyclingCategory) {
        this.recyclingCategory = recyclingCategory;
    }

    public void setEstimatedLifespan(int estimatedLifespan) {
        this.estimatedLifespan = estimatedLifespan;
    }

    public void setCalculatedImpact(double calculatedImpact) {
        this.calculatedImpact = calculatedImpact;
    }
}