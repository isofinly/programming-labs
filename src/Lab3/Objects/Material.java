package Lab3.Objects;

public enum Material {
    PAPER("Paper"),
    WOOD("Wood"),
    PLASTIC("Plastic"),
    RUBBER("Rubber"),
    CLOTH("Cloth"),
    METAL("Metal");

    private final String name;
    Material(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
