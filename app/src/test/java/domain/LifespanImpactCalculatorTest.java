package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LifespanImpactCalculatorTest {

    @Test
    void calculate_withTwoMaterials_returnsExpectedLifespan() {

        // Arrange
        RecyclingGuidance guidance =
                new RecyclingGuidance("Recycle correctly");

        Material steel = new Material(
                "Steel",
                20.0,
                RecyclingCategory.LOW,
                guidance);

        Material plastic = new Material(
                "Plastic",
                30.0,
                RecyclingCategory.MEDIUM,
                guidance);

        Product product = new Product(
                "Bottle",
                RecyclingCategory.MIXED,
                0);

        product.addMaterial(
                new ProductMaterial(steel, 50));

        product.addMaterial(
                new ProductMaterial(plastic, 50));

        LifespanImpactCalculator calculator =
                new LifespanImpactCalculator();

        // Act
        double result = calculator.calculate(product);

        // Assert
        assertEquals(4.0, result);
    }

    @Test
    void calculate_withEmptyMaterialList_returnsZero() {

        // Arrange
        Product product = new Product(
                "Empty Product",
                RecyclingCategory.MIXED,
                0);

        LifespanImpactCalculator calculator =
                new LifespanImpactCalculator();

        // Act
        double result = calculator.calculate(product);

        // Assert
        assertEquals(0.0, result);
    }

    @Test
    void calculate_appliesLifespanFormulaCorrectly() {

        // Arrange
        RecyclingGuidance guidance =
                new RecyclingGuidance("Recycle correctly");

        Material material = new Material(
                "Metal",
                25.0,
                RecyclingCategory.LOW,
                guidance);

        Product product = new Product(
                "Can",
                RecyclingCategory.LOW,
                0);

        product.addMaterial(
                new ProductMaterial(material, 100));

        LifespanImpactCalculator calculator =
                new LifespanImpactCalculator();

        // Act
        double result = calculator.calculate(product);

        // Assert
        // 100 / 25 = 4
        assertEquals(4.0, result);
    }
}