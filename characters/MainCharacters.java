package characters;
import Item.*;
import interfaces.*;
import planets.*;
import place.*;

public class MainCharacters extends Midget implements Hitable {
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
    public void hit(Object hitter,Object hitted) {
        if ( activeItem != null) {
            System.out.println(hitter + " hit " + activeItem.getName() + hitted );
        } else{
        System.out.printf( "%s hit %s \n",hitter,hitted);
        }
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public void walk(Object name, TypeOfPlaces secondPlaces) {
        this.typeOfPlace = secondPlaces;
        System.out.println(name + " is off to  " + secondPlaces.getName());
    }

    @Override
    public void see(Object name, Object object) {
        if (object.getClass() == Home.class) {
            System.out.print(name + " saw " + object.toString());

        } else if(object.getClass() == AnotherMidget.class) {
            System.out.println("Saw" + AnotherMidget.class + "and now is terrified that meeting might start");
        } 
        else {
            System.out.print("Said nothing interesting " + name);
        }
    }
    // public class Emotions{

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