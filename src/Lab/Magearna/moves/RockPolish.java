package Lab.Magearna.moves;

import ru.ifmo.se.pokemon.*;

public class RockPolish extends StatusMove {
    public RockPolish(double power, double accuracy) {
        super(Type.DARK, power, accuracy);
    }
    @Override
    protected void applySelfEffects(Pokemon Magearna) {
        Magearna.addEffect(new Effect().stat(Stat.SPEED, 2));
    }

    @Override
    public String describe() {
        return "uses Rock Polish (+2 speed)";
    }
}
