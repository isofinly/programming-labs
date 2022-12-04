package Item.ComplexItem;

public enum ComplexItemState {
    Stand("Standing(lying)"), 
    NoLongerInterActable("No longer interactable"), 
    Taken("Taken for good purposes"), 
    Occupied("Occupied"),
    Fly("Flying");

    private final String TextValue;

    ComplexItemState(String textValue) {
        this.TextValue = textValue;
    }

    @Override
    public String toString() {
        return TextValue;
    }
}