package characters;
import Item.*;
import interfaces.*;
import planets.*;
import place.*;

public class MainPoliceCharacter extends Police implements Hitable, Looking, Walking {
    private Stick activeItem;
    private boolean saw;
    
    public MainPoliceCharacter(String name, Planets planets, TypeOfPlaces firstPlace) {
        super(planets, name);
        this.typeOfPlace = firstPlace;
    }

    public void setActiveItem(Stick name) {
        activeItem = name;
    }

    @Override
    public String toString() {
        return name;
    }

    
    @Override
    public void hit(Object hitted) {
        if ( activeItem != null) {
            System.out.println(toString() +" hit with " + activeItem.getName() + hitted );
        } else{
        System.out.println(toString() +" hit " + hitted);
        }
    }

    @Override
    public void walk(TypeOfPlaces secondPlaces) {
        this.typeOfPlace = secondPlaces;
        System.out.println( toString() + " is off to " + secondPlaces.getPlacesName());
    }

    @Override
    public String see(Object object) {
        if (object.getClass() != null ) {
            // one of the midgets saw Neznayka and Fix
            System.out.println(" one of policeman-midget with name" + toString() + "saw " + object);
            this.saw = true;
            return object.getClass().getSimpleName();
        } 
        else {
            //Коротышка не увидел ничего интересного
            System.out.println(" one of the policeman-midget with name" + toString() + "did not see anything interesting ");
            this.saw = false; 
            return null;
        }
    }
}