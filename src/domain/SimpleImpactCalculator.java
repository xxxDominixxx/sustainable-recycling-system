package domain;

public class SimpleImpactCalculator implements CalculateImpact {

    @Override
    public double calculate(Product product) {
        double totalImpact = 0.0;

        for (ProductMaterial pm : product.getMaterials()) {
            totalImpact += pm.getMaterial().getImpact() * (pm.getPercentage() / 100.0);
        }

        return totalImpact;
    }
}