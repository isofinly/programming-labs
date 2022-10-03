package Lab.Omastar;

import Lab.Omanyte.moves.*;
import Lab.Omastar.moves.StoneEdge;
import ru.ifmo.se.pokemon.*;

public class Omastar extends Pokemon {
    public Omastar(String name, int lvl) {

        super(name, lvl);
        setStats(70,60,125,115,70,55);

        this.setType(Type.ROCK, Type.WATER);

        this.addMove(new StoneEdge(100, 80));
        this.addMove(new Leer(0, 100));
        this.addMove(new Blizzard(110, 70));
        this.addMove(new Constrict(10,100));
    }
}
