package domain;
public class Material {
    private String materialName;
    private String materialCategory;
    private double impactValue;
    private double weight;
    private String recyclingCategory;

    public Material(String materialName, String materialCategory, double impactValue, double weight, String recyclingCategory){
        this.materialName = materialName;
        this.materialCategory = materialCategory;
        this.impactValue = impactValue;
        this.weight = weight;
        this.recyclingCategory = recyclingCategory;
    }

    
}
