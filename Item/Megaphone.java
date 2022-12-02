package Item;
import exceptions.*;

public class Megaphone extends Item{
    private int volume;

    private int midgetAmount;

    public Megaphone(String name, int volume) {
        super(name);
        this.volume = volume;
        
    }
    @Override
    public String toString(){
        return name;
    }
}
