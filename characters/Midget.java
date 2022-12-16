package characters;

import exceptions.*;
import interfaces.*;
import planets.*;
import place.*;

public abstract class Midget extends Human {
    protected TypeOfPlaces typeOfPlace;

    public Midget(Planets planets) {
        Planets = planets;
    }
    
    public void callMidgets(TypeOfPlaces typeOfPlaces, int midgetAmount) throws MidgetAmountException {

    }
}
