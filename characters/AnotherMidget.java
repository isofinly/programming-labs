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
    
    public static int counter(){
        return midgetCreatedAmount;
    }

    public AnotherMidget(int power, Planets planets, TypeOfPlaces places) {
        super(planets);
        this.power = power;
        System.out.println("midget with power " + power + " appeared on planet " + planets + " and in place " + places);
        midgetCreatedAmount++;
    }

    @Override
    public void punch(Object punched) {
        if ( activeItem == null) {
            System.out.println( toString() + " hit with bare hands "  + punched );
        }
    }

    
    @Override
    public String see(Object subject) {
        if (subject.getClass() != null ) {
            System.out.println("One of the midgets saw " + subject);
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
        if (saw) {
            System.out.println("Mdiget shout that he (she) saw " + subject);
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
}
