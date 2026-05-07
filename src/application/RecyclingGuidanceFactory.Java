import java.util.Map;

public class RecyclingGuidanceFactory {

    private static final Map<RecyclingCategory, String> instructions = Map.of(
        RecyclingCategory.WOOD, "Sort the wooden parts to wood recycling",
        RecyclingCategory.METAL, "Sort the metal parts as metal recycling",
        RecyclingCategory.PLASTIC, "Sort the plastic parts as plastic recycling",
        RecyclingCategory.TEXTILE, "Sort the textile parts as textile recycling",
        RecyclingCategory.GLASS, "Sort the glass parts as glass recycling",
        RecyclingCategory.ELECTRONICS, "Sort the electronic parts as electronic recycling",
        RecyclingCategory.MIXED, "Disassemble the furniture if possible"
    );

    public static RecyclingGuidance create(RecyclingCategory category) {
        String instruction = instructions.getOrDefault(
            category,
            "Check local recycling rules."
        );

        return new RecyclingGuidance(category, instruction);
    }
}