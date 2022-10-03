package Lab.Omastar.moves;
import ru.ifmo.se.pokemon.*;

public class Leer extends StatusMove {
    public Leer(double power, double accuracy){
        super(Type.NORMAL,power,accuracy);
    }

    /**
     Leer lowers the target's Defense by one stage.
     */
    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.addEffect(new Effect().stat(Stat.DEFENSE, -1));
    }

    @Override
    public String describe() {
        return "uses Leer (foe loses 1 defense)";
    }
}