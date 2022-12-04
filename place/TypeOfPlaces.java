package place;

public enum TypeOfPlaces {
    HILL("Hill"),
    HOME("Home"),
    ROCKET_PLACE("Rocket place"),
    MEETING_PLACE("Meeting place"),
    PLAINS("Plains"),
    BUNCHES("Bunches"),
    VERANDA("Verand"),
    SQUARE("Square"),
    INDISTANCE("Somewhere in distance");
    private final String placesName;

    TypeOfPlaces(String placesName) {
        this.placesName = placesName;
    }

    public String getPlacesName() {
        return placesName;
    }
}
