package Lab.Omastar.moves;
import ru.ifmo.se.pokemon.*;

public class StoneEdge extends PhysicalMove {
    public StoneEdge(double power, double accuracy){
        super(Type.ROCK,power,accuracy);
    }

    /*
     Stone Edge deals damage and has an increased critical hit ratio (1⁄8 instead of 1⁄24).
     */

    @Override
    protected double calcCriticalHit (Pokemon var1, Pokemon var2) {
        if (((3 * var1.getStat(Stat.SPEED)) / 512.0) > Math.random()) {
            return 2.0d;
        } else {
            return 1.0d;
        }
    }

    @Override
    protected String describe() {
        return "uses Stone Edge";
    }
}
