package characters;


import exceptions.*;
import interfaces.*;
import interfaces.Interaction.*;
import planets.*;
import place.*;

public abstract class Human {
    
    protected TypeOfPlaces PlacesName;
    protected String Name;
    protected State HumanState;
    protected Planets Planets;
    protected Mood Mood;


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
        return PlacesName;
    }

    public void setTypeOfPlace(TypeOfPlaces placesName) {
        PlacesName = placesName;
    }
    
    public final State getState() {
        return HumanState;
    }
    
    public final void setState(State humanState) {
        HumanState = humanState;
    }

    public final Mood getMood() {
        return Mood;
    }

    public final void setMood(Mood mood) {
        Mood = mood;
    }

    // public void setActiveItem(Stick name)  {
    //     activeItem = name;
    // }
}
