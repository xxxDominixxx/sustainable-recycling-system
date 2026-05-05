package application;

import domain.CalculateImpact;
import domain.Product;
import domain.Material;

public class LifespanImpactCalculator implements CalculateImpact {

    @Override
    public double calculate(Product product) {
        double totalImpact = 0.0;

        for (Material material : product.getMaterials()) {
            totalImpact += material.getImpact() * (material.getPercentage() / 100.0);
        }

        if (product.getEstimatedLifespan() <= 0) {
            return totalImpact;
        }

        return totalImpact / product.getEstimatedLifespan();
    }
}