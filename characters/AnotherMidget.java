package characters;

import Item.*;
import exceptions.*;
import interfaces.*;
import interfaces.Interaction.*;
import place.*;
import planets.*;
import characters.Mood;


public class AnotherMidget extends Midget implements I_AnotherMidget, I_Object, I_PoliceCharacter, I_MainCharacter {

    public static int midgetCreatedAmount;
    private boolean saw;
    private int power;
    private int midgetAmount;
    
    public static int counter(){
        return midgetCreatedAmount;
    }
    
    
    public AnotherMidget(int power, Planets planets, TypeOfPlaces places) throws NegativeValueException{
        super(planets);
        if (power < 0) {
            throw new NegativeValueException(toString() + " is too weak to be a midget. better make him a baby, lol");
        }
        this.power = power;
        System.out.println("midget with power " + power + " appeared on planet " + planets + " and in place " + places.getPlacesName());
        midgetCreatedAmount++;
        setState(HumanState.Alive);
        setPlanets(planets);
        setTypeOfPlace(places);
        setMood(Mood.Calm);
    }

    @Override
    public void callMidgets(TypeOfPlaces placesName, int midgetAmount) throws MidgetAmountException{
        if (midgetAmount < 2) {
            throw new MidgetAmountException("Midgets are calling for more midgets and greater meeting! ");
        }
        else if (placesName == TypeOfPlaces.MOTHERTUSSIA) {
            AnotherMidget.this.setTypeOfPlace(TypeOfPlaces.RUSSIANPRISON);
            System.out.println(midgetAmount + "  " + toString() +  " tried to make a meeting but were caught by policemen and were sent to " + placesName.getPlacesName());
        } else {
            System.out.println(midgetAmount + " made meeting and now rioting in " + placesName.getPlacesName() );

        }
        
    }
    
    @Override
    public String toString() {
        return "Midgets do not have names, oi bruv";
    }

    @Override
    public void hit(AnotherMidget anotherMidget) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
            if (anotherMidget.getState() == HumanState.Alive) {
                if (anotherMidget.getPlanets() != this.getPlanets()) {
                    System.out.println(toString() + " tried to hit midget " + anotherMidget.toString() + " but he(she) is on another planet");
                }
                else {
                    System.out.println(toString() + " hit " + anotherMidget.toString() +  " at " + anotherMidget.getTypeOfPlace());
                    anotherMidget.setState(HumanState.Unconcesious);
                    System.out.println("and now " + anotherMidget.getClass().getSimpleName() + "  is " + anotherMidget.getState());
                }
            }
            else {
                System.out.println(toString() + " tried to hit " + anotherMidget.toString() + " but three's no point in it ");
            }
         }
        else {
            System.out.println(toString() + " tried to hit midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }

    @Override
    public void see(AnotherMidget anotherMidget) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
            if (anotherMidget.getPlanets() != this.getPlanets()) {
                System.out.println(toString() + " tried to see midget " + anotherMidget.toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
            }
            else {
                if (AnotherMidget.this.getMood() == Mood.DeadInsinde) {
                    System.out.println(toString() + " do not want to see anything ");
                } 
                else {
                System.out.println(toString() + " saw midget at " + anotherMidget.getTypeOfPlace().getPlacesName());
                saw = true;
                }
            }
        }
        else {
            System.out.println(toString() + " tried to see midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
        
    }

    @Override
    public void useStick(AnotherMidget anotherMidget) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
        if (anotherMidget.getState() == HumanState.Alive) {
            if (anotherMidget.getPlanets() != this.getPlanets()) {
                System.out.println(toString() + " tried to use stick on midget " + anotherMidget.toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
            }
            else {
                System.out.println(toString() + " used stick on midget at " + anotherMidget.getTypeOfPlace());
                anotherMidget.setState(HumanState.Unconcesious);
                System.out.println("and now " + anotherMidget.getClass().getSimpleName() + "  is " + anotherMidget.getState());
            }
        }
        else if (anotherMidget.getState() == HumanState.Unconcesious){
            System.out.println(toString() + " violently finished midget with stick at " + anotherMidget.getTypeOfPlace() + " and now " + anotherMidget.getClass().getSimpleName() + "  is not capable of doing anything(" + getState() + ") Why tho????");
            anotherMidget.setState(HumanState.Dead);
            System.out.println("and now " + anotherMidget.getClass().getSimpleName() + "  is " + anotherMidget.getState());
        }
    }
        else {
            System.out.println(toString() + " tried to use stick on midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
        
    }

    @Override
    public void useGun(AnotherMidget anotherMidget) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
        System.out.println("Midgets do not have guns, oi bruv");
    }
        else {
            System.out.println(toString() + " is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }

    @Override
    public void walk(TypeOfPlaces placesName) {
        
        if (AnotherMidget.this.getState() == HumanState.Alive) {
            if (AnotherMidget.this.getMood() == Mood.DeadInsinde) {
                System.out.println(toString() + " do not want to go anywhere ");
            } else if (AnotherMidget.this.getTypeOfPlace() == placesName.RUSSIANPRISON ) { 
                System.out.println(" Tried to escape but were caught and now unconscious ");
                AnotherMidget.this.setState(HumanState.Unconcesious);
            }     
            else {
            System.out.println(toString() + " walked to " + placesName.getPlacesName());
            AnotherMidget.this.setTypeOfPlace(placesName);
            System.out.println("and now " + AnotherMidget.this.getClass().getSimpleName() + "  is " + AnotherMidget.this.getTypeOfPlace());
        } }
        else if (AnotherMidget.this.typeOfPlace == placesName.HOME){
            System.out.println("I ain't goin' anywhere. I'm dead for ya peace off");
            AnotherMidget.this.setState(HumanState.Sleep);
            System.out.println("and now " + AnotherMidget.this.getClass().getSimpleName() + "  is " + AnotherMidget.this.getState());
        }
        else {
            System.out.println(toString() + " tried to walk to " + placesName.getPlacesName() + " but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }
    
    @Override
    public void hit(Object hitted){
        if (AnotherMidget.this.getState() == HumanState.Alive) {
        if (hitted instanceof AnotherMidget){
            System.out.println(toString() + " tried to hit object but missed and hit himself ");
            AnotherMidget.this.setState(HumanState.Unconcesious);
        }
        else if (hitted instanceof MainCharacters){
            System.out.println(toString() + " tried to hit object but missed and hit himself ");
            AnotherMidget.this.setState(HumanState.Unconcesious);
        } else {
            System.out.println(toString() + " hit object " + hitted.toString());
        }
    }
        else {
            System.out.println(toString() + " tried to hit object but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }

    @Override
    public void see(Object object) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
        if (object instanceof AnotherMidget) {
            if (AnotherMidget.this.getState() == HumanState.Alive) {
                if (((AnotherMidget) object).getState() == HumanState.Alive) {
                    if (((AnotherMidget) object).getPlanets() != this.getPlanets()) {
                        System.out.println(toString() + " tried to see midget " + ((AnotherMidget) object).toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
                    }
                    else {
                        System.out.println(toString() + " saw midget at " + ((AnotherMidget) object).getTypeOfPlace());
                    }
                }
                else {
                    System.out.println(toString() + " tried to see midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
                }
            }
            else {
                System.out.println(toString() + " tried to see midget but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
            }
        }
        else if (object instanceof AnotherMidget) {
           System.out.println("Policemen do not peek at their homies bruv" );
        }
        else {
            System.out.println("Policeman tried to sneaky-beaky peek at object " + object.toString() + " but he(she) failed and unconcesious ");
            AnotherMidget.this.setState(HumanState.Unconcesious);
        }
        
    }
        else {
            System.out.println(toString() + " tried to see object but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }


    @Override
    public void hit(PoliceCharacter anotherPolicemen) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
        if (anotherPolicemen.getState() == HumanState.Alive) {
            if (anotherPolicemen.getPlanets() != this.getPlanets()) {
                System.out.println(toString() + " tried to hit policeman " + anotherPolicemen.toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
            }
            else {
                System.out.println(toString() + " hit policeman " + anotherPolicemen.toString() + " at " + anotherPolicemen.getTypeOfPlace());
                anotherPolicemen.setState(HumanState.Unconcesious);
                System.out.println("and now " + AnotherMidget.this.getClass().getSimpleName() + "  is " + anotherPolicemen.getState());
            }
        }
        else if (anotherPolicemen.getState() == HumanState.Unconcesious){
            System.out.println(toString() + " violently finished policeman with bare hands at " + anotherPolicemen.getTypeOfPlace() + " and now " + AnotherMidget.this.getClass().getSimpleName() + "  is not capable of doing anything(" + getState() + ") Why tho????");
            anotherPolicemen.setState(HumanState.Dead);
            System.out.println("and now " + AnotherMidget.this.getClass().getSimpleName() + "  is " + anotherPolicemen.getState());
        }
    }
        else {
            System.out.println(toString() + " tried to hit object but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
        
    }


    @Override
    public void see(PoliceCharacter anotherPolicemen) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
        if (anotherPolicemen.getState() == HumanState.Alive) {
            if (anotherPolicemen.getPlanets() != this.getPlanets()) {
                System.out.println(toString() + " tried to see policeman " + anotherPolicemen.toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
            }
            else {
                System.out.println(toString() + " saw policeman at " + anotherPolicemen.getTypeOfPlace());
                saw = true;
            }
        }
    }

        else {
            System.out.println(toString() + " tried to see policeman but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
    }


    @Override
    public void useStick(PoliceCharacter anotherPolicemen) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
        if (anotherPolicemen.getState() == HumanState.Alive) {
            if (anotherPolicemen.getPlanets() != this.getPlanets()) {
                System.out.println(toString() + " tried to use stick on policeman " + anotherPolicemen.toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
            }
            else {
                System.out.println(toString() + " used stick on policeman " + anotherPolicemen.toString() + " at " + anotherPolicemen.getTypeOfPlace());
            }
        }
    }
        else {
            System.out.println(toString() + " tried to use stick but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
        
    }


    @Override
    public void useGun(PoliceCharacter anotherPolicemen) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
            System.out.println("Midgets do not have guns, oi bruv");
        }
            else {
                System.out.println(toString() + " is not capable of doing anything(" + getState() + ") Why tho????");
            }
    }


    @Override
    public void punch(PoliceCharacter anotherPolicemen) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
            if (anotherPolicemen.getState() == HumanState.Alive) {
                if (anotherPolicemen.getPlanets() != this.getPlanets()) {
                    System.out.println(toString() + " tried to punch policeman " + anotherPolicemen.toString() + " but oi bruh he(she) is on another planet how can you someone that far away");
                }
                else {
                    System.out.println(toString() + " punched " + anotherPolicemen.toString() + " at " + anotherPolicemen.getTypeOfPlace());
                    anotherPolicemen.setState(HumanState.Unconcesious);
                }
        
    } else {
        System.out.println(toString() + " tried to punch" + anotherPolicemen.toString() + " but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
    }
}   
}


    @Override
    public void punch(Object object) {
        if (AnotherMidget.this.getState() == HumanState.Alive) {
            System.out.println(toString() + " tried to punch object " + object.toString() + " but he(she) failed and unconcesious ");
            AnotherMidget.this.setState(HumanState.Unconcesious);
        }
        else {
            System.out.println(toString() + " tried to punch object but he(she) is not capable of doing anything(" + getState() + ") Why tho????");
        }
        
    }
}
