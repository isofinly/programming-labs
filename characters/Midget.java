package characters;

import exceptions.*;
import interfaces.*;
import planets.*;
import place.*;

public abstract class Midget implements Looking, Walking {
    protected TypeOfPlaces typeOfPlace;
    private Planets planets;
    protected State MidgetState;

    public Midget(Planets planets) {
        this.planets = planets;
    }

    public Planets getPlanets() {
        return planets;
    }

    public void setPlanets(Planets planets) {
        this.planets = planets;
    }

    public TypeOfPlaces getTypeOfPlace() {
        return typeOfPlace;
    }

    // public void hit(Object hitted) {
        
    // }

    public void walk(TypeOfPlaces typeOfPlaces ) {
    };

    public void callMidgets(TypeOfPlaces typeOfPlaces, int midgetAmount) throws MidgetAmountException {

    }

    public String see(Object object){
        return null;
        // return "Nothing interesting";
    };

    public String talk(Object object){
        return null;
    }

    public final State getState() {
        
        return MidgetState;
    }

    public final void setState(State midgetState) {
        MidgetState = midgetState;
    }
}
