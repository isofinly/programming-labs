package Lab3;


import Lab3.Objects.*;
import Lab3.Persons.*;

public class Lab3 {
    public static void main(String... args) {
        Znayika znayika = new Znayika(Mood.NEUTRAL, PersonState.STAND);
        Steklyashkin steklyashkin = new Steklyashkin(Mood.CURIOUS, PersonState.STAND);

        Book theBook = new Book(State.STAND, Material.PAPER, "Deep Dark Fantasy",
                new String[]{"Aboba", "noun verb"}, "Billy Herington");
        
        Telescope telescope = new Telescope(State.STAND, Material.METAL, 100, 1);

        znayika.startReading(theBook);
        steklyashkin.lookAt(telescope, znayika);

        System.out.println(znayika.getBook());
        System.out.println(steklyashkin.getTelescope());
    }
}
