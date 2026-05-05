package domain;

public class Material {

    private final String materialName;
    private final double impact;
    private final RecyclingCategory category;
    private final RecyclingGuidance guidance;
   

    public Material(String materialName,
                    double impact,
                    RecyclingCategory category,
                    RecyclingGuidance guidance)
                    {

        if (materialName == null || materialName.trim().isEmpty()) {
            throw new IllegalArgumentException("Material name cannot be empty.");
        }

        if (impact < 0) {
            throw new IllegalArgumentException("Impact cannot be negative.");
        }

        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null.");
        }

        if (guidance == null) {
            throw new IllegalArgumentException("Guidance cannot be null.");
        }

        this.materialName = materialName;
        this.impact = impact;
        this.category = category;
        this.guidance = guidance;
    
    }

    public String getMaterialName() {
        return materialName;
    }

    public double getImpact() {
        return impact;
    }

    public RecyclingCategory getCategory() {
        return category;
    }

    public RecyclingGuidance getGuidance() {
        return guidance;
    }

 

    @Override
    public String toString() {
        return materialName + " (" + category + ")";
    }
}