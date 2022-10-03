package Lab;

import Lab.Magearna.*;
import Lab.Nuzleaf.*;
import Lab.Omanyte.*;
import Lab.Omastar.*;
import Lab.Seedot.*;
import Lab.Shiftry.*;
import ru.ifmo.se.pokemon.*;

public class Main {
        public static void aboba() {

            Battle b = new Battle();

            Magearna p1 = new Magearna("Alfred", 666);
            Omanyte p2 = new Omanyte("Bob", 777);
            Omastar p3 = new Omastar("Jake", 987);

            Seedot p4 = new Seedot("Alex", 1337);
            Shiftry p5 = new Shiftry("Kebab", 761);
            Nuzleaf p6 = new Nuzleaf("Nick", 1337);

            b.addAlly(p1);
            b.addAlly(p5);
            b.addAlly(p3);

            b.addFoe(p2);
            b.addFoe(p4);
            b.addFoe(p6);

            b.go();
        }
    public static boolean chanceCheck(double chance) {
        return chance > (int) (Math.random()*100);
    }

    public static void main(String[] args) {
            aboba();
        }
}

