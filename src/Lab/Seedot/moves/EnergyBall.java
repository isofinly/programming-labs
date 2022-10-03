package Lab.Seedot.moves;


import ru.ifmo.se.pokemon.*;

public class EnergyBall extends SpecialMove {
    public EnergyBall(double power, double accuracy) {
        super(Type.GRASS, power, accuracy); //type, power, accuracy
    }
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