package characters;

import Item.*;
import exceptions.*;
import interfaces.*;
import place.*;
import planets.*;


public class AnotherPolicemen extends Police implements Shouting, Looking, Walking{
    boolean saw;
    boolean shout;
    private Stick activeItem;
    private int power;
    public boolean isDead;
    
    
    @Override
    public String toString() {
        return name;
    }

    public AnotherPolicemen(int power, Planets planets, TypeOfPlaces places, String name) {
        super(planets, name);
        this.power = power;
        System.out.println("Policeman with power " + power + " appeared on planet " + planets + " and in place " + places.getPlacesName());
    }

    public Boolean useStick(AnotherMidget anotherMidget) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
            return isDead = true;
        }
        else if (anotherMidget.getState() == State.Alive) {
            System.out.println("Policeman with the name " + toString() + " used a stick against midget with name " + anotherMidget.toString());
            anotherMidget.punch(this);
            // anotherMidget.setState(midgetState.Unconcesious);
            anotherMidget.setState(anotherMidget.getState() == State.Alive ? State.Unconcesious : State.Dead);
            return isDead = true;
        } else {
            System.out.println("Midget with the name " + anotherMidget.toString() + " is dead and no longer can be interacted with");
            return isDead = true;
        }
    }

    public Boolean useGun(AnotherMidget anotherMidget) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
            return isDead = true; 
        }
        else if (anotherMidget.getState() == State.Alive) {
            System.out.println("Policeman with the name " + toString() + " fired a gun at midget");
            anotherMidget.punch(this);
            anotherMidget.setState(anotherMidget.getState() == State.Alive ? State.Unconcesious : State.Dead);
            return isDead = true;
        } else {
            System.out.println("Midget with the name " + anotherMidget.toString() + " is dead and no longer can be interacted with");
            return isDead = true;
        }
    }




    @Override
    public void hit(Object hitted) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
        }
       else if ( activeItem != null) {
            System.out.println( toString() + " hit with" + activeItem.getName() + hitted );
        } else{
        System.out.println( toString() +  "hit " + hitted);
        }
    }

    @Override
    public String see(Object object) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
            return null;
        }
        else if (object.getClass() != null ) {
            // one of the midgets saw Neznayka and Fix
            System.out.println(toString() + " of the policeman saw " + object.getClass().getSimpleName());
            this.saw = true;
            return object.getClass().getSimpleName();
        } 
        else {
            //Коротышка не увидел ничего интересного
            System.out.println(" one of the midget-policemen with name " + toString() + "did not saw anyting ");
            this.saw = false; 
            return null;
        }
    }

    @Override
    public String Shout(Object object, String phrase) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
            return null;
        }
        else if (saw == true) {
            System.out.println("Police shout " + phrase + " to " + object);
            shout = true;
            return object.getClass().getSimpleName();
        } else {
            System.out.println("Policeman stayed silent");
            shout = false;
            return null;
        }
    }

    @Override
    public void walk(TypeOfPlaces typeOfPlaces) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
        } else {
        System.out.println(toString() + " went to " + typeOfPlaces.getPlacesName());
        this.typeOfPlace = typeOfPlaces;
        }
    }


    @Override
    public void callMidgets(TypeOfPlaces places, int midgetAmount) throws MidgetAmountException{
        if (midgetAmount < 2) {
            throw new MidgetAmountException("Midgets are calling for more midgets and greater meeting! ");
        }
        else{
            System.out.println(midgetAmount + " midgets started the meeting " );
        }
    }
    
}
