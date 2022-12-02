package place;

public enum TypeOfPlaces {
    HILL("Hill"),
    HOME("Home"),
    ROCKET_PLACE("Rocket place"),
    PLAINS("Plains"),
    BUNCHES("Bunches"),
    VERANDA("Verand"),
    SQUARE("Square"),
    INDISTANCE("Indistance");
    private final String placesName;

    TypeOfPlaces(String placesName) {
        this.placesName = placesName;
    }

    public String getPlacesName() {
        return placesName;
    }
}
