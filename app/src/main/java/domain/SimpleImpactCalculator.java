package domain;

public class SimpleImpactCalculator implements CalculateImpact {

    @Override
    public double calculate(Product product) {
        double totalImpact = 0.0;

        for (ProductMaterial productMaterial : product.getMaterials()) {
            totalImpact += productMaterial.getMaterial().getImpact() * (productMaterial.getPercentage() / 100.0);
        }

        return totalImpact;
    }
}