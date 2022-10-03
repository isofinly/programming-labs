package Lab.Shiftry.moves;
import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove{
    public DoubleTeam(double power, double accuracy) {
        super(Type.NORMAL,power,accuracy);
    }
    /**
     Double Team raises the user's Evasiveness by one stage, thus making the user more difficult to hit.
     **/
    @Override
    protected void applySelfEffects (Pokemon pokemon) {
        pokemon.setMod(Stat.EVASION, 1);
    }


    @Override
    protected String describe() {
        return "uses Double Team";
    }
}
