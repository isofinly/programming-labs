package Lab.Omanyte;

import Lab.Omanyte.moves.*;
import ru.ifmo.se.pokemon.*;


public class Omanyte extends Pokemon{
    public Omanyte(String name, int lvl){
        super(name,lvl);
        setStats(35,40,100,90,55,35);

        this.setType(Type.ROCK, Type.WATER);

        this.addMove(new Leer(0, 100));
        this.addMove(new Blizzard(110, 70));
        this.addMove(new Constrict(10,100));
    }
}
