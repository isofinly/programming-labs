package characters;

import Item.*;
import exceptions.*;
import interfaces.*;
import place.*;
import planets.*;


public class AnotherMidget extends Midget implements Talkable, Looking, Walking, Punchable{

    public static int midgetCreatedAmount;
    private boolean saw;
    private boolean shout;
    private Stick activeItem;
    private int power;
    private int midgetAmount;
    protected boolean isDead;
    
    public static int counter(){
        return midgetCreatedAmount;
    }

    public AnotherMidget(int power, Planets planets, TypeOfPlaces places) {
        super(planets);
        this.power = power;
        System.out.println("midget with power " + power + " appeared on planet " + planets + " and in place " + places.getPlacesName());
        midgetCreatedAmount++;
    }

    public Boolean useStick(AnotherMidget anotherMidget) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
            return isDead = true;
        } else if (anotherMidget.getState() == State.Alive) {
            System.out.println("Midget with the name " + toString() + " used a stick on " + anotherMidget.getClass() + " with name " + anotherMidget.toString());
            anotherMidget.punch(this);
            anotherMidget.setState(anotherMidget.getState() == State.Alive ? State.Unconcesious : State.Dead);
            return isDead = true;
        } else {
            System.out.println("Policeman with the name " + anotherMidget.toString() + " is dead and no longer can be interacted with");
            return isDead = true;
        }
    }

    public Boolean useStick(MainPoliceCharacter mainPoliceCharacter) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
            return isDead = true;
        } else if (mainPoliceCharacter.getState() == State.Alive) {
            System.out.println("Midget with the name " + toString() + " used a stick on " + mainPoliceCharacter.getClass() + " with name " + mainPoliceCharacter.toString());
            mainPoliceCharacter.hit(this);
            mainPoliceCharacter.setState(mainPoliceCharacter.getState() == State.Alive ? State.Unconcesious : State.Dead);
            return isDead = true;
        } else {
            System.out.println("Policeman with the name " + mainPoliceCharacter.toString() + " is dead and no longer can be interacted with");
            return isDead = true;
        }
    }

    public Boolean useStick(AnotherPolicemen anotherPolicemen) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
            return isDead = true;
        } else if (anotherPolicemen.getState() == State.Alive) {
            System.out.println("Midget with the name " + toString() + " used a stick on " + anotherPolicemen.getClass() + " with name " + anotherPolicemen.toString());
            anotherPolicemen.hit(this);
            anotherPolicemen.setState(anotherPolicemen.getState() == State.Alive ? State.Unconcesious : State.Dead);
            return isDead = true;
        } else {
            System.out.println("Policeman with the name " + anotherPolicemen.toString() + " is dead and no longer can be interacted with");
            return isDead = true;
        }
    }


    @Override
    public void punch(Object punched) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
        } else if ( activeItem == null) {
            System.out.println( toString() + " but definetely one of them hit with bare hands "  + punched );
        }
    }

    
    @Override
    public String see(Object subject) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
            return null;
        } else if (subject.getClass() != null ) {
            System.out.println(toString() + " but one of them saw " + subject);
            this.saw = true;
            return subject.getClass().getSimpleName();
        } 
        else {
            System.out.println("One of the midgets did not saw anybody else ");
            this.saw = false; 
            return null;
        }
    }
    
    @Override
    public String talk(Object subject) {
        if (isDead) {
            System.out.println("Oi bruv no one can help you now ");
            return null;
        } else if (saw) {
            System.out.println(toString() + " but he(she) shout that he(she) saw " + subject);
            shout = true;
            return subject.getClass().getSimpleName();
        } else {
            System.out.println("Nothing interesting to talk about");
            shout = false;
            return null;
        }
    }

    // @Override
    // public void walk(TypeOfPlaces typeOfPlaces) {
    //     this.typeOfPlace = typeOfPlaces;
    //     System.out.println("Midgets are crawling inbetween " + typeOfPlaces.getPlacesName());
    // }

    @Override
    public void callMidgets(TypeOfPlaces places, int midgetAmount) throws MidgetAmountException{
        if (midgetAmount < 2) {
            throw new MidgetAmountException("Midgets are calling for more midgets and greater meeting! ");
        }
        else{
            System.out.println(midgetAmount + " midgets started the meeting " );
        }
    }
    
    @Override
    public String toString() {
        return "Midgets do not have names, oi bruv";
    }
}
