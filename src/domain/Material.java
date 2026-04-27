package domain;

public class Material {
    private final String materialName;
    private final String materialCategory;
    private final double impactValue;
    private final String recyclingCategory;

    public Material(String materialName,
                    String materialCategory,
                    double impactValue,
                    String recyclingCategory) {

        if (materialName == null || materialName.trim().isEmpty()) {
            throw new IllegalArgumentException("Material name cannot be empty.");
        }

        if (materialCategory == null || materialCategory.trim().isEmpty()) {
            throw new IllegalArgumentException("Material category cannot be empty.");
        }

        if (impactValue < 0) {
            throw new IllegalArgumentException("Impact value cannot be negative.");
        }

        if (recyclingCategory == null || recyclingCategory.trim().isEmpty()) {
            throw new IllegalArgumentException("Recycling category cannot be empty.");
        }

        this.materialName = materialName;
        this.materialCategory = materialCategory;
        this.impactValue = impactValue;
        this.recyclingCategory = recyclingCategory;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getMaterialCategory() {
        return materialCategory;
    }

    public double getImpactValue() {
        return impactValue;
    }

    public String getRecyclingCategory() {
        return recyclingCategory;
    }

    @Override
    public String toString() {
        return materialName + " (" + materialCategory + ")";
    }
}