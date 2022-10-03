package Lab.Seedot;

import Lab.Seedot.moves.*;
import ru.ifmo.se.pokemon.*;

public class Seedot extends Pokemon {
    public Seedot(String name, int lvl){
        super(name,lvl);
        setStats(40,40,50,30,30,30);
        this.setType(Type.GRASS);
        this.addMove(new EnergyBall(90,100));
        this.addMove(new DoubleTeam(0,100));
    }
}
