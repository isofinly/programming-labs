package Item;

import Item.ComplexItem.*;
import characters.MainCharacters;
import interfaces.*;

public class Telescope extends ComplexItem implements Interactable{
    protected ComplexItemState TelescopeState;

    public Telescope(String name, ComplexItemState state, Weight objectWeight, Material material) {
        super(name, state, objectWeight, material);
        System.out.println("God gave midgets the telescope with the name " + name + " and in the state " + State + " and weight " + ComplexItemWeight + " and material " + Material);
    }

    public final ComplexItemState getState() {
        return TelescopeState;
    }

    @Override
    public String toString(){
        return name;
    }

    public void setState(ComplexItemState state) {
        if (State == state) {
            return;
        }
        System.out.println("Object now " + state.toString().toLowerCase());
        this.State = state;
    }

    public void zoomWithTelescope(Object person, Object subject) {
        if (State == ComplexItemState.Stand && person instanceof MainCharacters) {
            System.out.println(person + " zoomed with telescope at " + subject.toString());
            Telescope.this.setInteractedState(ComplexItemState.Occupied, person);
        }
        else if (State != ComplexItemState.Stand) {
            System.out.println("Telescope is not standing how are you going to zoom with it?");
        }
        else {
            System.out.println("You can't zoom with telescope");
        }
    }  

    @Override
    public void setInteractedState(ComplexItemState state, Object person) {
        if (person instanceof MainCharacters) {
            setState(state);
            System.out.println("Telescope state now is " + state + " by " + person);
        }
        else {
            System.out.println("Only Steklyashkin or his friends can interact with the telescope");
        }
        
    }

    // @Override
    // public void setInterActedState(ComplexItemState state, Object object) {
    //     if ComplexItemState == ComplexItemState.Stand {
    //         System.out.println("Midget with the name " + object.toString() + " took the telescope with the name " + name);
    //         ComplexItemState = ComplexItemState.Taken;
    //     } else {
    //         System.out.println("Midget with the name " + object.toString() + " put the telescope with the name " + name);
    //         ComplexItemState = ComplexItemState.Stand;
    //     }
    //     this.State = state;
    //     System.out.println("Telescope is " + state + " by " + object);
    // }
}
