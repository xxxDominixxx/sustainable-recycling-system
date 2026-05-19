package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import domain.RecyclingCategory;
import domain.RecyclingGuidance;

class RecyclingGuidanceFactoryTest {

    @Test
    void create_lowCategory_returnsLowGuidance() {

        // Act
        RecyclingGuidance guidance =
                RecyclingGuidanceFactory.create(RecyclingCategory.LOW);

        // Assert
        assertEquals(
                "Low impact: recycle or reuse",
                guidance.getInstruction());
    }

    @Test
    void create_mediumCategory_returnsMediumGuidance() {

        // Act
        RecyclingGuidance guidance =
                RecyclingGuidanceFactory.create(RecyclingCategory.MEDIUM);

        // Assert
        assertEquals(
                "Medium impact: recycle carefully",
                guidance.getInstruction());
    }

    @Test
    void create_highCategory_returnsHighGuidance() {

        // Act
        RecyclingGuidance guidance =
                RecyclingGuidanceFactory.create(RecyclingCategory.HIGH);

        // Assert
        assertEquals(
                "High impact: dispose responsibly",
                guidance.getInstruction());
    }

    @Test
    void create_mixedCategory_returnsMixedGuidance() {

        // Act
        RecyclingGuidance guidance =
                RecyclingGuidanceFactory.create(RecyclingCategory.MIXED);

        // Assert
        assertEquals(
                "Mixed materials: separate if possible",
                guidance.getInstruction());
    }
}