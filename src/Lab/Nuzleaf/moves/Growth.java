package Lab.Nuzleaf.moves;

import ru.ifmo.se.pokemon.*;


public class Growth extends StatusMove {
    public Growth(double power, double accuracy) {
        super(Type.DARK, power, accuracy);
    }

    /**
     Growth raises the user's Attack and Special Attack by one stage each. During harsh sunlight it raises each stat by two stages.
     **/
    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);
        Effect effect_1 = new Effect().stat(Stat.SPECIAL_ATTACK, 1);
        Effect effect_2 = new Effect().stat(Stat.ATTACK, 1);
        pokemon.addEffect(effect_1);
        pokemon.addEffect(effect_2);
    }

    @Override
    protected String describe() {
        return "uses Growth";
    }
}