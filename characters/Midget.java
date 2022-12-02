package characters;

import exceptions.MidgetAmountException;
import interfaces.*;
import planets.*;
import place.*;

public abstract class Midget implements Looking, Walking {
    protected TypeOfPlaces typeOfPlace;
    private Planets planets;

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

    public void hit(Object hitter,Object hitted) {
    }

    public void walk(TypeOfPlaces typeOfPlaces){}

    public void callMidgets(TypeOfPlaces typeOfPlaces, int midgetAmount) throws MidgetAmountException {}

    public void see(Object object){}

}
