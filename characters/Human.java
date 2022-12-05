package characters;

import exceptions.*;
import interfaces.*;
import interfaces.Interaction.*;
import planets.*;
import place.*;

public abstract class Human {
    
    protected TypeOfPlaces typeOfPlace;
    protected String Name;
    protected State HumanState;
    protected Planets Planets;

    public String getName() {
        return Name;
    }

    public final Planets getPlanets() {
        return Planets;
    }
    
    public void setPlanets(Planets planets) {
        Planets = planets;
    }
    
    public final TypeOfPlaces getTypeOfPlace() {
        return typeOfPlace;
    }

    public TypeOfPlaces setTypeOfPlace(TypeOfPlaces typeOfPlace) {
        return typeOfPlace;
    }
    
    public final State getState() {
        return HumanState;
    }
    
    public final void setState(State humanState) {
        HumanState = humanState;
    }
}
