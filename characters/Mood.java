package characters;

public enum Mood {
    
    Happy("happy"),
    Sad("sad"),
    Angry("angry"),
    Calm("calm"),
    Surprised("surprised"),
    DeadInsinde("dead inside");

    private final String TextValue;

    Mood(String textValue) {
        this.TextValue = textValue;
    }

    public String toString() {
        return TextValue;
    }
}
