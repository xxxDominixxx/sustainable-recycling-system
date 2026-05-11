package application;

import domain.RecyclingCategory;
import domain.RecyclingGuidance;

import java.util.Map;

public class RecyclingGuidanceFactory {

    private static final Map<RecyclingCategory, String> instructions = Map.of(
            RecyclingCategory.LOW,
            "Low impact: recycle or reuse",

            RecyclingCategory.MEDIUM,
            "Medium impact: recycle carefully",

            RecyclingCategory.HIGH,
            "High impact: dispose responsibly",

            RecyclingCategory.MIXED,
            "Mixed materials: separate if possible"
    );

    public static RecyclingGuidance create(RecyclingCategory category) {

        String text = instructions.getOrDefault(
                category,
                "Check local recycling rules."
        );

        return new RecyclingGuidance(text);
    }
}