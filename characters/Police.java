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

    // public abstract void hit(AnotherMidget anotherMidget);

    // public abstract void see(AnotherMidget anotherMidget);

    // public abstract void useStick(AnotherMidget anotherMidget);

    // public abstract void useGun(AnotherMidget anotherMidget);

    // public abstract void hit(Object hitted);
    
    // public abstract void see(Object object);

    // public void see(I_MainPoliceCharacter mainPoliceCharacter);

    // public void see(Object object);

    // public void walk(TypeOfPlaces typeOfPlaces);

    // public void see(I_AnotherPolicemen anotherPolicemen);
}
