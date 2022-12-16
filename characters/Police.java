package characters;

import exceptions.*;
import interfaces.*;
import interfaces.Interaction.*;
import planets.*;
import place.*;

public abstract class Police extends Human {
    protected TypeOfPlaces typeOfPlace;
    protected String Name;
    protected Planets Planets;

    public Police(Planets planets, String name){
        Planets = planets;
        Name = name;
    }
}
