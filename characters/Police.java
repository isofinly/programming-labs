package characters;

import exceptions.*;
import interfaces.*;
import planets.*;
import place.*;

public abstract class Police implements Looking, Walking, Hitable {
    protected TypeOfPlaces typeOfPlace;
    private Planets planets;
    protected String name;
    protected State PoliceState;

    public Police(Planets planets, String name) {
        this.planets = planets;
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void hit(Object hitted) {
    }

    public void walk(TypeOfPlaces typeOfPlaces){}

    public void callMidgets(TypeOfPlaces typeOfPlaces, int midgetAmount) throws MidgetAmountException {}

    public String see(Object object){
        return null;
    };
    
    public String talk(Object object){
        return null;
    }

    public final State getState() {
        return PoliceState;
    }

    public final void setState(State policeState) {
        PoliceState = policeState;
    }
}
