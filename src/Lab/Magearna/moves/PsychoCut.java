package Lab.Magearna.moves;
import ru.ifmo.se.pokemon.*;

public class PsychoCut extends PhysicalMove{

    public PsychoCut(double power, double accuracy){
        super(Type.PSYCHIC, power, accuracy);
    }

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
        return "uses Psycho Cut";
    }
}
