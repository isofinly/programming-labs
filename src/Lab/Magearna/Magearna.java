package Lab.Magearna;

import Lab.Magearna.moves.*;
import ru.ifmo.se.pokemon.*;


public class Magearna extends Pokemon{
    public Magearna(String name, int lvl){
        super(name,lvl);
        setStats(90,95,115,130,115,65);
        this.setType(Type.STEEL, Type.FAIRY);
        this.addMove(new PowerGem(80, 100));
        this.addMove(new PsychoCut(70,100));
        this.addMove(new RockPolish(0,100));
        this.addMove(new ShadowClaw(70,100));
    }
}
