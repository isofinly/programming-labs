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
 * Make steklyashkin 
 * Make steklyashkin look at the midgets
 * Make police
 * Make police use sticks
 * Make stecklyashkin use telescope and see police firing at midgets
 * if midget has 999 power it kills police otherwise police put midget in jail
 */

public class Story {
    public static void main(String[] args) throws Exception {
        Megaphone megaphone = new Megaphone("Megaphone", 30);
        
        AnotherMidget midgetMeetingTeam = new AnotherMidget(2, Planets.MOON,TypeOfPlaces.INDISTANCE);
        AnotherMidget midget = new AnotherMidget(3,Planets.MOON,TypeOfPlaces.PLAINS);
        
        midgetMeetingTeam.walk(TypeOfPlaces.SQUARE);
        midgetMeetingTeam.callMidgets(TypeOfPlaces.PLAINS, AnotherMidget.midgetCreatedAmount);

        midget.walk(TypeOfPlaces.BUNCHES);

        System.out.println("Enter names of objects MainCharacters:");
        Scanner scanner = new Scanner(System.in);
        String neznaykaName = scanner.nextLine();
        String fixName = scanner.nextLine();

        MainCharacters neznayka = new MainCharacters(neznaykaName, Planets.EARTH, TypeOfPlaces.PLAINS);
        MainCharacters fix = new MainCharacters(fixName, Planets.EARTH, TypeOfPlaces.PLAINS);

        Home home = new Home("Aboba home", Planets.EARTH);

        midgetMeetingTeam.hit(neznaykaName, home);

        midget.see(midget,neznayka);
        midget.talk();

        Stick stick = new Stick("stick ");
        fix.setActiveItem(stick);
        fix.hit(fix,neznayka);

        neznayka.walk(TypeOfPlaces.HILL);
        fix.walk(TypeOfPlaces.HILL);


        DetailedMidget klops = new DetailedMidget("Clops",100, " with pink ","bald ", "shmoll", false, "naked", Planets.MOON,TypeOfPlaces.VERANDA);

        klops.sit(TypeOfPlaces.VERANDA);
        //System.out.println(klops);
    }
}
