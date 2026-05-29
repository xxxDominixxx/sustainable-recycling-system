package domain;

public class ProductMaterial {

    private final Material material;
    private final double percentage;

    public ProductMaterial(Material material, double percentage) {

        if (material == null) {
            throw new IllegalArgumentException("Material cannot be null");
        }

        if (percentage <= 0 || percentage > 100) {
            throw new IllegalArgumentException(
                    "Percentage must be between 0 and 100"
            );
        }

        this.material = material;
        this.percentage = percentage;
    }

    public Material getMaterial() {
        return material;
    }

    public double getPercentage() {
        return percentage;
    }
}