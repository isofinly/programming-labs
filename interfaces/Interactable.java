package interfaces;
import Item.ComplexItem.*;

public interface Interactable {
    
    default ComplexItemState getInteractedState() {
        return ComplexItemState.Stand;
    }

    void setInteractedState(ComplexItemState state, Object object);
}
