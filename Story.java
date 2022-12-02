import Item.*;
import characters.*;
import place.*;
import planets.*;
import exceptions.*;
import interfaces.*;

import java.util.Scanner;


/*
 * TO DO 
 * Make intentions or reuse emotions from MainCharacters
 * Add neznaika
 * Add rocket 
 * Make steklyashkin 
 * Make steklyashkin look at the midgets
 * Make police
 * Make police use sticks
 * Make stecklyashkin use telescope and see police firing at midgets
 * if midget has 999 power it kills police otherwise police put midget in jail
 */

public class Story {
    public static void main(String[] args) throws Exception {
        
        String zapominalka = "";
        Megaphone megaphone = new Megaphone("Megaphone", 30);
        
        AnotherMidget midgetMeetingTeam = new AnotherMidget(2, Planets.MOON,TypeOfPlaces.INDISTANCE);
        AnotherMidget midget = new AnotherMidget(3,Planets.MOON,TypeOfPlaces.PLAINS);
        
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

        Rocket rocket = new Rocket("Rocket", 10.0);
        rocket.ascend(rocket, 0, Planets.EARTH);

        Home home = new Home("Aboba home", Planets.EARTH);

        midgetMeetingTeam.punch(home);

        // if midget wants to talk before he or she sees something then there's nothing to talk about
        zapominalka = midget.see(policeman_1);
        midget.talk(zapominalka);

        Stick stick = new Stick("Dubinka ");

        policeman_2.setActiveItem(stick);
        policeman_2.hit(midget);

        // MainCharacters.walk(policeman_2.getName(),TypeOfPlaces.HILL);

        policeman_2.walk(TypeOfPlaces.HILL);
        policeman_1.getName();

        // DetailedMidget klops = new DetailedMidget("Clops",100, " with pink ","bald ", "shmoll", false, "naked", Planets.MOON,TypeOfPlaces.VERANDA);
        // klops.sit(TypeOfPlaces.VERANDA);
        //System.out.println(klops);
    }
}
