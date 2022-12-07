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
 *
 * Make stecklyashkin use telescope and see police firing at midgets 
 * Make steklyashkin look at the midgets
 * Add neznaika 
 * Allow looking at places
 * 
 * Check whether the midgets and police are in the same place
 * 
 */

public class Story {
    public static void main(String[] args) throws Exception {
        
        String zapominalka = "";
        Megaphone megaphone = new Megaphone("Megaphone", 30);
        
        AnotherMidget midgetMeetingTeam = new AnotherMidget(2, Planets.EARTH,TypeOfPlaces.MOTHERTUSSIA);
        AnotherMidget midget = new AnotherMidget(3,Planets.EARTH,TypeOfPlaces.MOTHERTUSSIA);
        
        // midgetMeetingTeam.walk(TypeOfPlaces.SQUARE);
        
        // zapominalka = midget.see(megaphone);
        // midget.talk(zapominalka);
        

        // if midgetcreatedamount < 2 then there's no meeting and exception is thrown
        
        // midget.walk(TypeOfPlaces.BUNCHES);
        
        // System.out.println("Enter names of objects MainCharacters:");
        // Scanner scanner = new Scanner(System.in);
        // String policeman_1_name = scanner.nextLine();
        // String policeman_2_name = scanner.nextLine();
        
        PoliceCharacter policeman_1 = new PoliceCharacter(30, Planets.EARTH, TypeOfPlaces.HOME, "Zurab");
        PoliceCharacter policeman_2 = new PoliceCharacter(20, Planets.EARTH, TypeOfPlaces.ROCKET_PLACE, "Levanovich");
        PoliceCharacter policeman_3 = new PoliceCharacter(3, Planets.EARTH, TypeOfPlaces.ROCKET_PLACE, "Policeman_3");
        
        midgetMeetingTeam.callMidgets(TypeOfPlaces.MOTHERTUSSIA, AnotherMidget.midgetCreatedAmount);

        midget.see(midgetMeetingTeam);
        
        MainCharacters Steklyashkin = new MainCharacters("Steklyashkin", Planets.EARTH, TypeOfPlaces.HOME);
        Telescope telescope = new Telescope("Steklyashkin beloved telescope", ComplexItemState.Stand, Weight.Heavy, Material.Wood);
        
        // Steklyashkin.setActiveItem(telescope); 
        telescope.zoomWithTelescope(Steklyashkin, midget);
        telescope.setInteractedState(ComplexItemState.Occupied, Steklyashkin);

        midgetMeetingTeam.hit(midget);

        // System.out.println(policeman_1.getState());
        
        policeman_1.hit(midget);
        policeman_2.useStick(midget);

        Rocket rocket = new Rocket("Rockettt", 10.0);
        // speed cannot be 0 otherwise it will throw an exception
        rocket.ascend(100, Planets.MOON);

        Home home = new Home("Aboba home", Planets.EARTH);

        midgetMeetingTeam.punch(home);

        Stick stick = new Stick("Dubinka ", ComplexItemState.Stand, Weight.Heavy, Material.Wood, 10);

        midget.useGun(policeman_3);
        midget.useStick(policeman_3);

        policeman_3.useGun(midget);

        policeman_2.hit(midget);

        policeman_3.setState(State.Alive);
        policeman_2.useStick(midgetMeetingTeam);
        midgetMeetingTeam.punch(policeman_2);
        midgetMeetingTeam.punch(policeman_2);
        policeman_3.useGun(midget);

        midget.useStick(policeman_1);

        policeman_1.walk(TypeOfPlaces.HOME);
        policeman_3.walk(TypeOfPlaces.HOME);


        // MainCharacters.walk(policeman_2.getName(),TypeOfPlaces.HILL);


        /*
         * 
         */

        // DetailedMidget klops = new DetailedMidget("Clops",100, " with pink ","bald ", "shmoll", false, "naked", Planets.MOON,TypeOfPlaces.VERANDA);
        // klops.sit(TypeOfPlaces.VERANDA);
        //System.out.println(klops);
    }
}
