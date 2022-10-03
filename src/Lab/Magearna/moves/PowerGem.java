package Lab.Magearna.moves;

import ru.ifmo.se.pokemon.*;


public class PowerGem extends SpecialMove{
    public PowerGem(double power, double accuracy){
        //Power Gem deals damage with no additional effect.
        super(Type.ROCK,power,accuracy);
    }

    @Override
    protected String describe() {
        return "uses Power Gem";
    }
}
