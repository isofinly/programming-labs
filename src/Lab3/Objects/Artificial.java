package Lab3.Objects;

import Lab3.Interfaces.Interface_2;

public abstract class Artificial implements Interface_2 {

    private State ObjectState;
    private final Material ObjectMaterial;

    public Artificial(State currentState, Material material) {
        ObjectState = currentState;
        ObjectMaterial = material;
    }

    public final State getState() {
        return ObjectState;
    }

    public final void setState(State newState) {
        ObjectState = newState;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject.getClass().isInstance(this)) {
            Artificial other = (Artificial) otherObject;
            return ObjectState == other.ObjectState && ObjectMaterial == other.ObjectMaterial;
        }
        return false;
    }

    @Override
    public String toString() {
        return "SomeObject {" +
                "ObjectState=" + ObjectState +
                ", ObjectMaterial=" + ObjectMaterial +
                '}';
    }

    @Override
    public int hashCode() {
        return ObjectState.hashCode() + ObjectMaterial.hashCode();
    }

    protected Material getMaterial() {
        return ObjectMaterial;
    }
}
