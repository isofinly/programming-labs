package characters;

public enum State {
    Stand("stadning"),
    Sit("sitting"),
    Sleep("sleeping"),
    Run("running"),
    Alive("alive"),
    Unconcesious("unconcesious"),
    Dead("dead");

    private final String TextValue;

    State(String textValue) {
        this.TextValue = textValue;
    }

    public String toString() {
        return TextValue;
    }
}