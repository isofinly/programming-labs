package characters;
import Item.*;
import interfaces.*;
import planets.*;
import place.*;

public class MainCharacters extends Midget implements Hitable, Looking, Walking {
    
    private boolean saw;
    private String name;
    private Stick activeItem;
    
    public MainCharacters(String name,Planets planets, TypeOfPlaces firstPlace) {
        super(planets);
        this.name = name;
       this.typeOfPlace = firstPlace;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public void setActiveItem(Stick name) {
        activeItem = name;
    }

    @Override
    public void hit(Object hitted) {
        if ( activeItem != null) {
            System.out.println(" hit " + activeItem.getName() + hitted );
        } else{
        System.out.println(" hit " + hitted);
        }
    }

    @Override
    public String toString(){
        return name;
    }

    // @Override
    // public void walk(TypeOfPlaces secondPlaces) {
    //     this.typeOfPlace = secondPlaces;
    //     System.out.println(name + " is off to  " + secondPlaces.getPlacesName());
    // }

    @Override
    public String see(Object object) {
        if (object.getClass() != null ) {
            // one of the midgets saw Neznayka and Fix
            System.out.println(" one of the midgets saw " + object.getClass().getSimpleName());
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
    // public class Emotions{

    @Override
    public void walk(Object name, TypeOfPlaces secondPlaces) {
        this.typeOfPlace = secondPlaces;
        System.out.println(name + " is off to  " + secondPlaces.getPlacesName());
    }

        // public void excited(Object name,Planets planetPlace, Plants plants){
        //     if (planetPlace != Planets.EARTH){
        //         System.out.println("Same plants but biggger size " + plants.getSize());
        //     }
        //     if (plants.getPlanet() == Planets.MOON & plants.getSize() == "small") {
        //         // начал привыкать к тому, что на
        //         System.out.println(name + " started to get used to the fact that "
        //                 + planetPlace.toString() + " plants " + plants.getSize());
        //     }
        // }
    // }
}