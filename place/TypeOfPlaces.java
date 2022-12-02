package place;

public enum TypeOfPlaces {
    HILL("Hill"),
    PLAINS("Plains"),
    BUNCHES("Bunches"),
    VERANDA("Verand"),
    SQUARE("Square"),
    INDISTANCE("Indistance");
    private final String name;

    TypeOfPlaces(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
