package Lab.Seedot.moves;
import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove{
    public DoubleTeam(double power, double accuracy) {
        super(Type.NORMAL,power,accuracy);
    }
    @Override
    protected void applySelfEffects (Pokemon pokemon) {
        pokemon.setMod(Stat.EVASION, 1);
    }


    @Override
    protected String describe() {
        return "uses Double Team";
    }
}