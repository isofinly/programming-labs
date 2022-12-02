package characters;

import Item.*;
import exceptions.*;
import interfaces.*;
import place.*;
import planets.*;


public class AnotherPolicemen extends Police implements Talkable, Looking, Walking{
    public static int midgetCreatedAmount;
    boolean saw;
    boolean shout;
    private Stick activeItem;
    private int power;
    private int midgetAmount;
    
    public AnotherPolicemen(int power, Planets planets, TypeOfPlaces places, String name) {
        super(planets, name);
        this.power = power;
        System.out.println("midget with power " + power + " appeared " +  " and on planet " + planets + " and in place " + places);
        midgetCreatedAmount++;
    }
    public static int counter(){
        return midgetCreatedAmount;
    }

    @Override
    public void hit(Object hitted) {
        if ( activeItem != null) {
            System.out.println( "hui" + " hit " + activeItem.getName() + hitted );
        } else{
        System.out.println( "hui" +  "hit " + hitted);
        }
    }

    @Override
    public String see(Object object) {
        if (object.getClass() != null ) {
            // one of the midgets saw Neznayka and Fix
            System.out.println(" one of the policeman saw " + object.getClass().getSimpleName());
            this.saw = true;
            return object.getClass().getSimpleName();
        } 
        else {
            //Коротышка не увидел ничего интересного
            System.out.println(" one of the midgets did not saw anybody else ");
            this.saw = false; 
            return null;
        }
    }

    @Override
    public void talk(Object object) {
        if (saw == true) {
            System.out.println("Mdiget shout");
            shout = true;
        } else {
            System.out.println("Nothing interesting");
            shout = false;
        }
    }

    @Override
    public void walk(TypeOfPlaces typeOfPlaces) {
        System.out.println("Midgets are crawling inbetween " + typeOfPlaces.getPlacesName());
        this.typeOfPlace = typeOfPlaces;
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
