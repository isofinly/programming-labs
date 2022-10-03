package Lab.Shiftry;

import Lab.Shiftry.moves.*;
import ru.ifmo.se.pokemon.*;


public class Shiftry extends Pokemon {
    public Shiftry(String name, int lvl){

        super(name,lvl);
        setStats(90,100,60,90,60,80);

        this.setType(Type.GRASS);

        this.addMove(new EnergyBall(90,100));
        this.addMove(new DoubleTeam(0,100));
        this.addMove(new NastyPlot(0,100));
        this.addMove(new Growth(0,100));
    }
}