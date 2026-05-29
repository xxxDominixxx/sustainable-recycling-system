package domain;

public class LifespanImpactCalculator implements CalculateImpact {

    @Override
    public double calculate(Product product) {

        double totalImpact = 0.0;

        for (ProductMaterial productMaterial : product.getMaterials()) {
            totalImpact += productMaterial.getMaterial().getImpact()
                    * (productMaterial.getPercentage() / 100.0);
        }

        if (totalImpact <= 0) {
            return 0;
        }

        // Simple lifespan model (adjustable)
        return Math.ceil(100.0 / totalImpact);
    }
}