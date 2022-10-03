package Lab.Shiftry.moves;
import ru.ifmo.se.pokemon.*;


public class NastyPlot extends StatusMove {
    public NastyPlot(double power, double accuracy) {
        super(Type.DARK, power, accuracy);
    }
    /**
     Nasty Plot raises the user's Special Attack by two stages.
     **/
    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);
        Effect effect = new Effect().stat(Stat.SPECIAL_ATTACK, 2);
        pokemon.addEffect(effect);
    }

    @Override
    protected String describe() {
        return "uses Nasty Plot";
    }
}