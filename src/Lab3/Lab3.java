package Lab3;

import Lab3.Objects.*;
import Lab3.Persons.*;

public class Lab3 {
    public static void main(String... args) {

        Znayika znayika = new Znayika(Mood.NEUTRAL, PersonState.STAND);
        Steklyashkin steklyashkin = new Steklyashkin(Mood.CURIOUS, PersonState.STAND);
        Policeman kebabov = new Policeman(Mood.FURIOUS, PersonState.STAND, "Рядовой Кебабов",
                new String[]{"Пыво"});

        Book theBook = new Book(State.STAND, Material.PAPER, "Deep Dark Fantasy",
                new String[]{"Aboba", "noun verb"}, "Billy Herington");

        Telescope telescope = new Telescope(State.STAND, Material.METAL, 100, 1);


        znayika.startReading(theBook);
        System.out.println(znayika.getBook());
        kebabov.bonk(znayika);
        kebabov.arrest(znayika);
        steklyashkin.lookAt(telescope, znayika);
        telescope.setOccupied(steklyashkin, true);
        System.out.println(steklyashkin.getTelescope());

    }
}
