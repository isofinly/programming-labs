package Item;

import characters.AnotherMidget;
import exceptions.*;
import interfaces.*;
import place.*;
import planets.*;

public class Rocket extends Item implements Flyable{
    public static boolean isRocketTakenOff;
    private int velocity;
    private double angle; 
    private Planets planets;
    
    public boolean isRocketTakenOff() {
        return isRocketTakenOff;
    }

    public Rocket(String name, double angle) {
        super(name);
        System.out.println("The most advanced rocket in the world was created by genious community of marvelous engineers with the name " + name + " and placed with angle " + angle);
        this.angle = angle;
    }

    @Override
    public String toString(){
        return name;
    }

    public void theRocket(){
        System.out.println("The rocket is flying");
    }


    @Override
    public void ascend(int speed, Planets planets) throws Exception {
        if (speed > 0){
            System.out.println( toString() + " ascended to " + planets + " with speed " + speed + " km/h");
            this.planets = planets;
            isRocketTakenOff = true;
        }
        else if(speed == 0 ){
            System.out.println("Rocket stands still -_- ");
        }
        else if (planets == null) {
            throw new NullPlanetException("Planet cannot be null");
        } 
        else {
            throw new NegativeValueException("Speed can't be negative");
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
            throw new NegativeValueException("Speed can't be negative");
        }
    }
}
