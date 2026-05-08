package domain;

public enum RecyclingCategory {

    LOW("Low environmental impact"),
    MEDIUM("Medium environmental impact"),
    HIGH("High environmental impact"),
    MIXED("Contains multiple recycling categories");

    private final String description;

    RecyclingCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}



