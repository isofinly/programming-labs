package characters;
import Item.*;
import interfaces.*;
import planets.*;
import place.*;

public class MainPoliceCharacter extends Police implements Hitable, Looking, Walking {
    private String name;
    private Stick activeItem;
    private boolean saw;
    
    public MainPoliceCharacter(String name,Planets planets, TypeOfPlaces firstPlace) {
        super(planets, name);
        this.typeOfPlace = firstPlace;
    }

    public String getName( ) {
        return name;
    }

    public void setActiveItem(Stick name) {
        activeItem = name;
    }

    @Override
    public void hit(Object hitted) {
        if ( activeItem != null) {
            System.out.println("Policeman hit with " + activeItem.getName() + hitted );
        } else{
        System.out.println("Policeman hit " + hitted);
        }
    }

    @Override
    public void walk(TypeOfPlaces secondPlaces) {
        this.typeOfPlace = secondPlaces;
        System.out.println( getName() + " is off to " + secondPlaces.getPlacesName());
    }

    @Override
    public String see(Object object) {
        if (object.getClass() != null ) {
            // one of the midgets saw Neznayka and Fix
            System.out.println(" one of policeman-midget saw " + object);
            this.saw = true;
            return object.getClass().getSimpleName();
        } 
        else {
            //Коротышка не увидел ничего интересного
            System.out.println(" one of the policeman-midget did not see anything interesting ");
            this.saw = false; 
            return null;
        }
    }
}