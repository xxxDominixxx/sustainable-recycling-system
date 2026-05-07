package domain;

public class SimpleImpactCalculator implements CalculateImpact {

    @Override
    public double calculate(Product product) {
        double totalImpact = 0.0;

        for (Material material : product.getMaterials()) {
            totalImpact += material.getImpact() * (material.getPercentage() / 100.0);
        }

        return totalImpact;
    }
}