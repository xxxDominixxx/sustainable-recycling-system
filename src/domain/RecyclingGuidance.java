package domain;

public class RecyclingGuidance {

    private final RecyclingCategory category;
    private final String instruction;

    public RecyclingGuidance(RecyclingCategory category, String instruction) {
        this.category = category;
        this.instruction = instruction;
    }

    public RecyclingCategory getCategory() {
        return category;
    }

    public String getInstruction() {
        return instruction;
    }
}
