package Lab3.Objects;

public enum State {
    FLY("Flying"),
    STAND("Standing");
    private final String name;

    State(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
}