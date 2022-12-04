import Item.*;
import Item.ComplexItem.*;
import characters.*;
import place.*;
import planets.*;
import exceptions.*;
import interfaces.*;

import java.util.Scanner;


/*
 * TO DO 
 * Make intentions or reuse emotions from MainCharacters / scrap it
 * Add neznaika 
 * Add rocket / done
 * Make steklyashkin / done
 * Make steklyashkin look at the midgets
 * Make police / done
 * Make police use sticks / done
 * Make stecklyashkin use telescope and see police firing at midgets 
 * if midget has 999 power it kills police otherwise police put midget in jail / scrap it
 */

public class Story {
    public static void main(String[] args) throws Exception {
        
        String zapominalka = "";
        Megaphone megaphone = new Megaphone("Megaphone", 30);
        
        AnotherMidget midgetMeetingTeam = new AnotherMidget(2, Planets.EARTH,TypeOfPlaces.INDISTANCE);
        AnotherMidget midget = new AnotherMidget(3,Planets.EARTH,TypeOfPlaces.PLAINS);
        
        midgetMeetingTeam.walk(TypeOfPlaces.SQUARE);
        
        zapominalka = midget.see(megaphone);
        midget.talk(zapominalka);
        
        midgetMeetingTeam.callMidgets(TypeOfPlaces.PLAINS, AnotherMidget.midgetCreatedAmount);

        midget.walk(TypeOfPlaces.BUNCHES);
        
        // System.out.println("Enter names of objects MainCharacters:");
        // Scanner scanner = new Scanner(System.in);
        // String policeman_1_name = scanner.nextLine();
        // String policeman_2_name = scanner.nextLine();

        MainPoliceCharacter policeman_1 = new MainPoliceCharacter("Zurab", Planets.EARTH, TypeOfPlaces.ROCKET_PLACE);
        MainPoliceCharacter policeman_2 = new MainPoliceCharacter("Levanovich", Planets.EARTH, TypeOfPlaces.ROCKET_PLACE);
        AnotherPolicemen policeman_3 = new AnotherPolicemen(3, Planets.EARTH, TypeOfPlaces.ROCKET_PLACE, "Policeman_3");

        MainCharacters Steklyashkin = new MainCharacters("Steklyashkin", Planets.EARTH, TypeOfPlaces.HOME);
        Telescope telescope = new Telescope("Steklyashkin beloved telescope", ComplexItemState.Stand, Weight.Heavy, Material.Wood);
        
        Steklyashkin.setActiveItem(telescope);
        telescope.zoomWithTelescope(Steklyashkin, midget);
        // telescope.setInteractedState(ComplexItemState.Occupied, Steklyashkin);


        Rocket rocket = new Rocket("Rockettt", 10.0);
        rocket.ascend(100, Planets.MOON);

        Home home = new Home("Aboba home", Planets.EARTH);

        midgetMeetingTeam.punch(home);

        // if midget wants to talk before he or she sees something then there's nothing to talk about
        zapominalka = midget.see(policeman_1);
        midget.talk(zapominalka);

        Stick stick = new Stick("Dubinka ", ComplexItemState.Fly, Weight.Heavy, Material.Wood, 10);

        midget.setState(State.Alive);

        policeman_2.setActiveItem(stick);
        policeman_2.hit(midget);

        policeman_3.setState(State.Alive);
        policeman_3.useStick(midget);
        policeman_3.useGun(midget);
        midget.useStick(policeman_1);

        policeman_1.walk(TypeOfPlaces.ROCKET_PLACE);
        policeman_2.walk(TypeOfPlaces.MEETING_PLACE);


        // MainCharacters.walk(policeman_2.getName(),TypeOfPlaces.HILL);


        /*
         * 
         */

        // DetailedMidget klops = new DetailedMidget("Clops",100, " with pink ","bald ", "shmoll", false, "naked", Planets.MOON,TypeOfPlaces.VERANDA);
        // klops.sit(TypeOfPlaces.VERANDA);
        //System.out.println(klops);
    }
}
