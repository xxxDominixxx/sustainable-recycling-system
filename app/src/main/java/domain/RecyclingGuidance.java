package domain;

public class RecyclingGuidance {

    private final String instruction;

    public RecyclingGuidance(String instruction) {

        if (instruction == null || instruction.isBlank()) {
            throw new IllegalArgumentException("Instruction cannot be empty");
        }

        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    @Override
    public String toString() {
        return instruction;
    }
}