package application;

import domain.RecyclingCategory;
import domain.RecyclingGuidance;
import domain.CalculateImpact;
import domain.Product;

public class RecyclingService {

    private final CalculateImpact impactCalculator;

    public RecyclingService(CalculateImpact impactCalculator) {
        this.impactCalculator = impactCalculator;
    }

    public double calculateImpact(Product product) {
        return impactCalculator.calculate(product);
    }


    public RecyclingGuidance getGuidance(RecyclingCategory category) {
        RecyclingGuidance guidance =
            RecyclingGuidanceFactory.create(category);

        return guidance;
    }
}
