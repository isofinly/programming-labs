package Item.ComplexItem;

public abstract class ComplexItem {
    protected final Weight ComplexItemWeight;
    protected final Material Material;
    protected ComplexItemState State;
    protected String name;

    public ComplexItem(String name, ComplexItemState state, Weight objectWeight, Material material) {
        this.ComplexItemWeight = objectWeight;
        this.State = state;
        this.Material = material;
        this.name = name;
    }

    public ComplexItemState getState() {
        return State;
    }
    
    public String getName() {
        return name;
    }
    
    public Weight getWeight() {
        return ComplexItemWeight;
    }
    
    public void setState(ComplexItemState state) {
        System.out.println("Объект " + this.getClass().getSimpleName() + " теперь " + state.toString().toLowerCase());
        this.State = state;
    }
}