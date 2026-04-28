package domain;

public class Material {

    private final String materialName;
    private final double impact;
    private final RecyclingCategory category;
    private final RecyclingGuidance guidance;
    private final double percentage;

    public Material(String materialName,
                    double impact,
                    RecyclingCategory category,
                    RecyclingGuidance guidance,
                    double percentage) {

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

        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100.");
        }

        this.materialName = materialName;
        this.impact = impact;
        this.category = category;
        this.guidance = guidance;
        this.percentage = percentage;
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

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return materialName + " (" + category + ")";
    }
}