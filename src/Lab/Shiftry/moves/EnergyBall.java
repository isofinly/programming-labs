package Lab.Shiftry.moves;
import ru.ifmo.se.pokemon.*;

public class EnergyBall extends SpecialMove {
    public EnergyBall(double power, double accuracy) {
        super(Type.GRASS, power, accuracy); //type, power, accuracy
    }
    /**
     Energy Ball deals damage and has a 10% chance of lowering the target's Special Defense by one stage.
     **/
    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random()<=0.1) {
            Effect decreaseSpecialDefenseEffect = new Effect();
            decreaseSpecialDefenseEffect.stat(Stat.SPECIAL_DEFENSE, -1);
            pokemon.addEffect(decreaseSpecialDefenseEffect);
        }
    }
    @Override
    protected String describe() {
        return "uses Energy Ball";
    }
}