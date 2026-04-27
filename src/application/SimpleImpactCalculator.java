package application;

import domain.CalculateImpact;
import domain.Product;
//import domain.Material; // Aktiveras när Material har getters

public class SimpleImpactCalculator implements CalculateImpact {

    @Override
    public double calculate( Product product) {
        double totalImpact = 0.0;

             
        //* */ TODO:
    
        // När Material-klassen har getters: 
        //-getImpactValue()
        //-getWeight()
        //
        //koden nedan ska aktiveras då : 
        //
        //
        // for (Material material : product.getMaterials()){
        //  totalImpact += material.getImpactValue() * material.getWeight();
        //}
        

        return totalImpact;
    }

}
