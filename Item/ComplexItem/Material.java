package Item.ComplexItem;

public enum Material {
    Wood("Whood"),
    Gold("Gold"),
    Metal("Metall"),
    Paper("Papers please"),
    Plastic("Plastic");

    private final String TextValue;

    Material(String textValue) {
        this.TextValue = textValue;
    }

    @Override
    public String toString() {
        return TextValue;
    }
}
