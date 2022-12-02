package planets;

public enum Planets {
    EARTH("earth"),
    MOON("moon");

    private final String Type;
    Planets(String t) {
        Type = t;
    }

    @Override
    public String toString() {
        return Type;
    }
}