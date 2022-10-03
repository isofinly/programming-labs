package Lab.Omanyte.moves;
import Lab.Main;
import ru.ifmo.se.pokemon.*;

public class Constrict extends PhysicalMove {
    public Constrict(double power, double accuracy){
        super(Type.NORMAL,power,accuracy);
    }
    /**
     Constrict deals damage and has a 10% chance of lowering the target's Speed by one stage.
     **/

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);
        if (Main.chanceCheck(10)) {
            Effect decreaseSpeed = new Effect();
            decreaseSpeed.stat(Stat.SPEED, -1);
            pokemon.addEffect(decreaseSpeed);
//            System.out.println("Constrict was used and foe loses 1 speed");
        }
    }

    @Override
    protected String describe() {
        return "uses Constrict";
    }
}

