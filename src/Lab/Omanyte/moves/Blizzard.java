package Lab.Omanyte.moves;
import Lab.*;
import ru.ifmo.se.pokemon.*;


public class Blizzard extends SpecialMove{
    public Blizzard(double power, double accuracy){
        //Power Gem deals damage with no additional effect.
        super(Type.ICE,power,accuracy);
    }

    /**
     Blizzard deals damage and has a 10% chance of freezing the target. It will hit both opponents in a double battle or adjacent opponents in a triple battle.

     Ice type Pokémon, those with the ability Magma Armor or those behind a Substitute cannot be frozen.

     During a hailstorm, Blizzard ignores accuracy.
     **/

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);
        if (Main.chanceCheck(10)){
            Effect.freeze(pokemon);
            // System.out.println("Blizzard was used and foe is frozen");

        }
    }

    @Override
    protected String describe() {
        return "uses Blizzard";
    }
}
