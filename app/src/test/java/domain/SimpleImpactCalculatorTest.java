package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SimpleImpactCalculatorTest {

    @Test
    void shouldCalculateImpactForProductWithMaterials() {
        // Arrange
        RecyclingGuidance guidance = new RecyclingGuidance("Recycle as wood");
        Material wood = new Material("Wood", 0.31, RecyclingCategory.LOW, guidance);

        Product product = new Product("Chair", RecyclingCategory.LOW, 10);
        product.addMaterial(new ProductMaterial(wood, 100));

        SimpleImpactCalculator calculator = new SimpleImpactCalculator();

        // Act
        double result = calculator.calculate(product);

        // Assert
        assertEquals(0.31, result, 0.001);
    }

    @Test
    void shouldReturnZeroWhenProductHasNoMaterials() {
        // Arrange
        Product product = new Product("Empty product", RecyclingCategory.LOW, 10);
        SimpleImpactCalculator calculator = new SimpleImpactCalculator();

        // Act
        double result = calculator.calculate(product);

        // Assert
        assertEquals(0.0, result, 0.001);
    }
}