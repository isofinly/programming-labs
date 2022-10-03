package Lab.Nuzleaf;

import Lab.Nuzleaf.moves.*;
import ru.ifmo.se.pokemon.*;


public class Nuzleaf extends Pokemon{
    public Nuzleaf(String name, int lvl){
        super(name,lvl);
        setStats(70,70,40,60,40,60);

        this.setType(Type.ROCK, Type.WATER);

        this.addMove(new DoubleTeam(0,100));
        this.addMove(new EnergyBall(90,100));
        this.addMove(new Growth(0,100));
    }
}
