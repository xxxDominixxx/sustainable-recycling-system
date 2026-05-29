package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class MaterialTest {

    @Test
    void constructor_validValues_createsMaterial() {

        // Arrange
        RecyclingGuidance guidance =
                new RecyclingGuidance(
                        "Recycle in plastic bin");

        // Act
        Material material = new Material(
                "Plastic",
                2.0,
                RecyclingCategory.LOW,
                guidance);

        // Assert
        assertEquals("Plastic", material.getMaterialName());
        assertEquals(2.0, material.getImpact());
        assertEquals(RecyclingCategory.LOW, material.getCategory());
        assertEquals(guidance, material.getGuidance());
    }

    @Test
    void constructor_negativeImpact_throwsException() {

        // Arrange
        RecyclingGuidance guidance =
                new RecyclingGuidance(
                        "Recycle in plastic bin");

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> new Material(
                        "Plastic",
                        -1.0,
                        RecyclingCategory.LOW,
                        guidance));
    }

    @Test
    void constructor_emptyName_throwsException() {

        // Arrange
        RecyclingGuidance guidance =
                new RecyclingGuidance(
                        "Recycle in plastic bin");

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> new Material(
                        "",
                        2.0,
                        RecyclingCategory.LOW,
                        guidance));
    }
}