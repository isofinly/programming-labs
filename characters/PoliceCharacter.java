package characters;

import Item.*;
import exceptions.*;
import interfaces.*;
import interfaces.Interaction.*;
import place.*;
import planets.*;


public class PoliceCharacter extends Police implements I_AnotherMidget, I_Object, I_MainCharacter {
    boolean saw;
    boolean shout;
    private Stick activeItem;
    private double gunSize;
    private int gunShots;
    
    
    @Override
    public String toString() {
        return Name;
    }

    public PoliceCharacter(double gunSize, Planets planets, TypeOfPlaces places, String name) {
        super(planets, name);
        this.gunSize = gunSize;
        System.out.println("Policeman with gunsmhize " + gunSize + " appeared on planet " + planets + " and in place " + places.getPlacesName());
        if (gunSize > 0) {
            System.out.println(toString() + " Policeman can shoot ");
         }
         else {
             System.out.println("It is not a valid policeman it's rather a healer lol");
         }
        setState(HumanState.Alive);
        setPlanets(planets);
        setTypeOfPlace(places);
        setMood(Mood.Angry);
    }

    @Override
    public void hit(AnotherMidget anotherMidget) {
        if (PoliceCharacter.this.getState() == HumanState.Alive) {
            if (anotherMidget.getState() == HumanState.Alive) {
                if (anotherMidget.getPlanets() != PoliceCharacter.this.getPlanets()) {
                    System.out.println("Policeman " + toString() + " tried to hit midget " + anotherMidget.toString() + " but he(she) is on another planet");
                }
                else {
                    System.out.println("Policeman " + toString() + " hit midget ");
                    anotherMidget.setState(HumanState.Unconcesious);
                    System.out.println("and now " + anotherMidget.getClass().getSimpleName() + " is " + anotherMidget.getState());
                }
            }
            else {
                System.out.println("Policeman " + toString() + " tried to hit " + anotherMidget.toString() + " but three's no point in it ");
            }
         }
        else {
            System.out.println("Policeman " + toString() + " tried to hit midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }

    @Override
    public void see(AnotherMidget anotherMidget) {
        if (PoliceCharacter.this.getState() == HumanState.Alive) {
        if (anotherMidget.getState() == HumanState.Alive) {
            if (anotherMidget.getPlanets() != this.getPlanets()) {
                System.out.println("Policeman " + toString() + " tried to see midget " + anotherMidget.toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
            }
            else {
                System.out.println("Policeman " + toString() + " saw midget ");
                saw = true;
            }
        }
    }
        else {
            System.out.println("Policeman " + toString() + " tried to see midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }

    @Override
    public void useStick(AnotherMidget anotherMidget) {
        if (PoliceCharacter.this.getState() == HumanState.Alive && PoliceCharacter.this.gunSize > 0) {
        if (anotherMidget.getState() == HumanState.Alive) {
            if (anotherMidget.getPlanets() != this.getPlanets()) {
                System.out.println("Policeman " + toString() + " tried to use stick on midget " + anotherMidget.toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
            }
            else {
                System.out.println("Policeman " + toString() + " used stick on midget ");
                anotherMidget.setState(HumanState.Unconcesious);
                System.out.println("and now " + anotherMidget.getClass().getSimpleName() + "  is " + anotherMidget.getState());
            }
        }
        else if (anotherMidget.getState() == HumanState.Unconcesious){
            System.out.println("Policeman " + toString() + " violently finished " + anotherMidget.getClass().getSimpleName() + " with stick " + "  in state(" + anotherMidget.getState() + ") Why tho????");
            anotherMidget.setState(HumanState.Dead);
            System.out.println("and now " + anotherMidget.getClass().getSimpleName() + "  is " + anotherMidget.getState());
        }
    }
        else {
            System.out.println("Policeman " + toString() + " tried to use stick on midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
        
    }

    @Override
    public void useGun(AnotherMidget anotherMidget) {
        if (gunShots < 3 ) {
        if (PoliceCharacter.this.getState() == HumanState.Alive) {
        if (anotherMidget.getState() == HumanState.Alive) { 
            if (anotherMidget.getPlanets() != this.getPlanets()) {
                System.out.println("Policeman " + toString() + " tried to use gun on midget " + anotherMidget.toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
            }
            else {
                System.out.println("Policeman " + toString() + " shot " + anotherMidget.toString() + " ");
                anotherMidget.setState(HumanState.Unconcesious);
                gunShots ++;
                System.out.println("and now " + anotherMidget.getClass().getSimpleName() + "  is " + anotherMidget.getState());
            }
        }
        else if (anotherMidget.getState() == HumanState.Unconcesious){
            System.out.println("Policeman " + toString() + " violently finished midget with gun " + anotherMidget.getClass().getSimpleName() + "  in state(" + anotherMidget.getState() + ") Why tho????");
            anotherMidget.setState(HumanState.Dead);
            gunShots ++;
            System.out.println("and now " + anotherMidget.getClass().getSimpleName() + "  is " + anotherMidget.getState());
        }
    }
        else {
            System.out.println("Policeman " + toString() + " tried to use gun on midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }
    else {
        System.out.println("Gun is overheated and can't be used so policeman " + toString() + " used stick on midget ");
        useStick(anotherMidget);
    }
}

    @Override
    public void walk(TypeOfPlaces placesName) {
        
        if (PoliceCharacter.this.getState() == HumanState.Alive) {
            System.out.println("Policeman " + toString() + " walked to " + placesName.getPlacesName());
            PoliceCharacter.this.setTypeOfPlace(placesName);
        }
        else if (PoliceCharacter.this.PlacesName == placesName.HOME){
            System.out.println("I ain't goin' anywhere. I'm dead for ya peace off");
            PoliceCharacter.this.setState(HumanState.Sleep);
        }
        else {
            System.out.println("Policeman " + toString() + " tried to walk to " + placesName.getPlacesName() + " but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }

    @Override
    public void hit(Object hitted){
        if (PoliceCharacter.this.getState() == HumanState.Alive  && PoliceCharacter.this.gunSize > 0) {
        if (hitted instanceof AnotherMidget){
            System.out.println("Policeman " + toString() + " tried to hit object but missed and hit himself ");
            PoliceCharacter.this.setState(HumanState.Unconcesious);
            
        }
        else if (hitted instanceof PoliceCharacter){
            System.out.println("Policemen do not hit their homies bruv" );
        }
        else if (hitted instanceof MainCharacters){
            System.out.println("Policeman " + toString() + " tried to hit object but missed and hit himself ");
            PoliceCharacter.this.setState(HumanState.Unconcesious);
            
        } else {
            System.out.println("Policeman " + toString() + " hit object " + hitted.toString());
        }
    }
        else {
            System.out.println("Policeman " + toString() + " tried to hit object but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }

    @Override
    public void see(Object object) {
        if (PoliceCharacter.this.getState() == HumanState.Alive) {
        if (object instanceof AnotherMidget) {
            if (PoliceCharacter.this.getState() == HumanState.Alive) {
                if (((AnotherMidget) object).getState() == HumanState.Alive) {
                    if (((AnotherMidget) object).getPlanets() != this.getPlanets()) {
                        System.out.println("Policeman " + toString() + " tried to see midget " + ((AnotherMidget) object).toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
                    }
                    else {
                        System.out.println("Policeman " + toString() + " saw midget at " + ((AnotherMidget) object).getTypeOfPlace());
                    }
                }
                else {
                    System.out.println("Policeman " + toString() + " tried to see midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
                }
            }
            else {
                System.out.println("Policeman " + toString() + " tried to see midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
            }
        }
        else if (object instanceof PoliceCharacter) {
           System.out.println("Policemen do not peek at their homies bruv" );
        }
        else {
            System.out.println("Policeman tried to sneaky-beaky peek at object " + object.toString() + " but he(she) failed and unconcesious ");
            PoliceCharacter.this.setState(HumanState.Unconcesious);
            System.out.println("and now " + PoliceCharacter.this.getClass().getSimpleName() + "  is " + PoliceCharacter.this.getState());
        }
        
    }
        else {
            System.out.println("Policeman " + toString() + " tried to see object but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }

    @Override
    public void punch(Object object) {
        hit(object);
    }
    
}
