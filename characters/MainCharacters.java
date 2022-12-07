package characters;
import Item.*;
import interfaces.*;
import planets.*;
import place.*;

public class MainCharacters extends Midget {
    
    private boolean saw;
    private String name;
    private Object activeItem;
    
    
    public MainCharacters(String name, Planets planets, TypeOfPlaces firstPlace) {
        super(planets);
        this.name = name;
        this.typeOfPlace = firstPlace;
        setState(HumanState.Alive);

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


}