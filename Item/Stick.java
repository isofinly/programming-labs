package Item;

import Item.ComplexItem.*;
import characters.*;
import interfaces.*;

public class Stick extends ComplexItem {
    private int size;

    public Stick(String name, ComplexItemState State, Weight ComplexItemWeight, Material Material, int size) {
        super(name, State, ComplexItemWeight, Material);
        System.out.println("God gave midgets the stick with the name " + name + " and in the state " + State + " and weight " + ComplexItemWeight + " and material " + Material + " and size " + size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stick stick = (Stick) o;
        return size == stick.size;
    }

    @Override
    public int hashCode() {
        return size;
    }

    @Override
    public String toString() {
        return "Stick {" +
                "size=" + size +
                '}' + "with name " + name;
    }

}
