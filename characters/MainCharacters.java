package characters;
import Item.*;
import interfaces.*;
import planets.*;
import place.*;

public class MainCharacters extends Midget implements Looking, Walking {
    
    private boolean saw;
    private String name;
    private Object activeItem;
    
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
    
    @Override
    public String toString(){
        return name;
    }
    
    public void setActiveItem(Object name) {
        activeItem = name;
        System.out.println(toString() + " now uses " + activeItem.toString());
    }

    @Override
    public String see(Object object) {
        if (object.getClass() != null ) {
            System.out.println(toString() + " saw " + object.getClass().getSimpleName());
            this.saw = true;
            return object.getClass().getSimpleName();
        } 
        else if (object.getClass() == AnotherMidget.class) { 
            System.out.println(" have to use telescope to see " + object.getClass().getSimpleName());
            this.saw = false; 
            return null;
        }
        else if (object.getClass() == DetailedMidget.class) { 
            System.out.println(" have to use telescope to see " + object.getClass().getSimpleName());
            this.saw = false; 
            return null;
        }
        else {
            System.out.println(" one of the main characters did not saw anything interesting");
            this.saw = false; 
            return null;
        }
    }
    // public class Emotions{


        @Override
        public void walk(TypeOfPlaces typeOfPlaces) {
            System.out.println(toString() + " went to " + typeOfPlaces.getPlacesName());
            this.typeOfPlace = typeOfPlaces;
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