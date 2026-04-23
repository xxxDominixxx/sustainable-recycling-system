package application;

import domain.CalculateImpact;
import domain.Product;
import domain.RecyclingCategory;
import domain.RecyclingGuidance;

public class RecyclingService {

    private final CalculateImpact impactCalculator;

    public RecyclingService() {
        this.impactCalculator = new SimpleImpactCalculator();
    }

    public double calculateImpact(Product product) {
        return impactCalculator.calculate(product);
    }

    public RecyclingGuidance getGuidance(RecyclingCategory category) {
        switch (category) {
            case WOOD:
                return new RecyclingGuidance(category, "Sort the wooden parts to wood recycling.");
            case METAL:
                return new RecyclingGuidance(category, "Sort the metal parts as metal recycling.");
            case PLASTIC:
                return new RecyclingGuidance(category, "Sort the plastic parts as plastic recycling.");
            case TEXTILE:
                return new RecyclingGuidance(category, "Sort the textile parts as textile recycling.");
            case GLASS:
                return new RecyclingGuidance(category, "Sort the glass parts as glass recycling.");
            case ELECTRONICS:
                return new RecyclingGuidance(category, "Sort the electronic parts as electronic recycling.");
            case MIXED:
                return new RecyclingGuidance(category, "Disassemble the furniture if possible and sort each material separately.");
            default:
                return new RecyclingGuidance(category, "Check local recycling rules.");
        }
    }
}