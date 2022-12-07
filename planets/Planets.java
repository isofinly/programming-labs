package planets;

public enum Planets {
    EARTH("Earth"),
    MOON("Moon");

    private final String Type;
    Planets(String t) {
        Type = t;
    }

    @Override
    public String toString() {
        return Type;
    }
}