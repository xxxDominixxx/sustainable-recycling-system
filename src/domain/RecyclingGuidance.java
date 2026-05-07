package domain;

public enum RecyclingGuidance {

    RECYCLE("Recycle at appropriate station"),
    REUSE("Reuse or donate if possible"),
    COMPOST("Can be composted"),
    DISPOSE("Dispose in general waste");

    private final String instruction;

    RecyclingGuidance(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }
}