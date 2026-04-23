package domain;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productName;
    private String productCategory;
    private int estimatedLifespan;
    private List<Material> materials;

    public Product(String productName, String category, int estimatedLifespan){
        this.productName = productName;
        this.productCategory = category;
        this.estimatedLifespan = estimatedLifespan;
        this.materials = new ArrayList<>();

    }
    public void addMaterial(Material material) {
        materials.add(material);
    }
    public String getProductName(){
        return productName;
    }

    public String getProductCategory(){
        return productCategory;
    }

    public int getEstimatedLifespan(){
        return estimatedLifespan;
    }

    public List<Material> getMaterials() {
        return materials;
    }
    

}
