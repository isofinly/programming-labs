package characters;

import exceptions.*;
import interfaces.*;
import planets.*;
import place.*;

public abstract class Police implements Looking, Walking, Hitable {
    protected TypeOfPlaces typeOfPlace;
    private Planets planets;
    private String name;

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
        return null;};
    
    public void talk(Object object){

    }
}
