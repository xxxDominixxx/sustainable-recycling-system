package application;

import domain.CalculateImpact;
import domain.Product;


public class SimpleImpactCalculator implements CalculateImpact {

    @Override
    public double calculate( Product product) {
        double totalImpact = 0;

                // TODO:
        // När Product exponerar nödvändig data
        // ska impact beräknas här utifrån produktens material.

        return totalImpact;
    }

}
