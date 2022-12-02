package characters;

import Item.*;
import exceptions.*;
import interfaces.*;
import place.*;
import planets.*;


public class AnotherMidget extends Midget implements Looking, Talkable {
    public static int midgetCreatedAmount;
    boolean saw;
    boolean shout;
    private Stick activeItem;
    private int power;
    private int midgetAmount;
    public AnotherMidget(int power, Planets planets, TypeOfPlaces places) {
        super(planets);
        this.power = power;
        System.out.println("midget with power " + power + " appeared " +  " and on planet " + planets + " and in place " + places);
        midgetCreatedAmount++;
    }
    public static int counter(){
        return midgetCreatedAmount;
    }

    @Override
    public void hit(Object hitter,Object hitted) {
        if ( activeItem != null) {
            System.out.println(hitter + " hit " + activeItem.getName() + hitted );
        } else{
        System.out.printf( "%s hit %s \n",hitter,hitted);
        }
    }

    @Override
    public void see(Object name,Object object) {
        if (object.getClass() == MainCharacters.class ) {
            // one of the midgets saw Neznayka and Fix
            System.out.println(" one of the midgets saw " + name);
            this.saw = true;
        } else if (object.getClass() == Midget.class){
            // one of the midgets saw another midget
            System.out.println(" one of the midgets saw another midget");
            this.saw = true;
        } else if (object.getClass() == Megaphone.class){
            // one of the midgets saw megaphone
            System.out.println(" one of the midgets saw megaphone");
            this.saw = true;
        } else if (object.getClass() == Stick.class){
            // one of the midgets saw stick
            System.out.println(" one of the midgets saw stick");
            this.saw = true;
        } 
        else {
            //Коротышка не увидел ничего интересного
            System.out.println(" one of the midgets saw anybody else ");
            this.saw = false; 
        }
    }

    @Override
    public void talk() {
        if (saw == true) {
            System.out.println("Mdiget shout");
            shout = true;
        } else {
            System.out.println("Nothing interesting");
            shout = false;
        }
    }

    @Override
    public void walk(Object name, TypeOfPlaces typeOfPlaces) {
        System.out.println("Midgets are crawling inbetween " + typeOfPlaces.getName());
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
