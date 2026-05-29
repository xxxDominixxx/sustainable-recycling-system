package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void constructor_validValues_createsProduct() {

        // Arrange & Act
        Product product = new Product(
                "Laptop",
                RecyclingCategory.MEDIUM,
                5);

        // Assert
        assertEquals("Laptop", product.getProductType());
        assertEquals(RecyclingCategory.MEDIUM, product.getRecyclingCategory());
        assertEquals(5, product.getEstimatedLifespan());
        assertTrue(product.getMaterials().isEmpty());
    }

    @Test
    void addMaterial_addsMaterialToList() {

        // Arrange
        Product product = new Product(
                "Laptop",
                RecyclingCategory.MEDIUM,
                5);

        RecyclingGuidance guidance =
                new RecyclingGuidance("Recycle as metal");

        Material material = new Material(
                "Steel",
                2.0,
                RecyclingCategory.LOW,
                guidance);

        ProductMaterial productMaterial =
                new ProductMaterial(material, 3.0);

        // Act
        product.addMaterial(productMaterial);

        // Assert
        assertEquals(1, product.getMaterials().size());
        assertEquals(productMaterial, product.getMaterials().get(0));
    }

    @Test
    void setCalculatedImpact_setsImpactCorrectly() {

        // Arrange
        Product product = new Product(
                "Laptop",
                RecyclingCategory.MEDIUM,
                5);

        // Act
        product.setCalculatedImpact(12.5);

        // Assert
        assertEquals(12.5, product.getCalculatedImpact());
    }
}