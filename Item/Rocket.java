package Item;
import exceptions.*;
import interfaces.*;
import place.*;
import planets.*;

public class Rocket extends Item implements Flyable{
    public static boolean isRocketTakenOff;
    private int velocity;
    private double angle; 
    private Planets planets;
    
    public static boolean isRocketTakenOff() {
        return isRocketTakenOff;
    }

    public Rocket(String name, double angle) {
        super(name);
        this.angle = angle;
    }

    // @Override
    // public void flyTo(Object name, Planets planets) {
    //     System.out.println(" Rocket called " + name +  " flew to " + planets);
    //     // System.out.println(" Rocket is flying to " + typeOfPlaces.getName());
    // }

    @Override
    public void ascend(int speed, Planets planets) throws Exception {
        if (speed > 0){
            System.out.println("Rocket " + " ascended to " + planets + " with speed km/h");
            this.planets = planets;
            isRocketTakenOff = true;
        }
        else if(speed == 0 ){
            System.out.println("Rocket can't ascend with speed 0");
        }
        else if (planets == null) {
            throw new NullPlanetException("Planet cannot be null");
        } 
        else {
            throw new NegativeSpeedException("Speed can't be negative");
        }
    }

    @Override
    public void descend(int speed, Planets planets) throws Exception {
        if (speed > 0) {
            System.out.println("Rocket " + " descended to " + planets + " with speed km/h");
            this.planets = planets;
            isRocketTakenOff = true;
        } 
        else if(speed == 0 ){
            System.out.println("Rocket can't descend with speed 0");
        }
        else if (planets == null) {
            throw new NullPlanetException("Planet cannot be null");
        } 
        else {
            throw new NegativeSpeedException("Speed can't be negative");
        }
    }
}
