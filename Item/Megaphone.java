package Item;
import exceptions.*;

public class Megaphone extends Item{
    private int volume;

    private int midgetAmount;

    public Megaphone(String name, int volume) {
        super(name);
        this.volume = volume;
    }
    
    public void callMidgets(int midgetAmount) {
    //     try{
    //     if(midgetAmount < 2){
    //         throw new EnoughMidgetsException();
    //     }
    // } 
    // catch (EnoughMidgetsException e){
    //     e.getMassage();
    //     System.out.println("Midgets are calling for more midgets and greater meeting! ");
    //     midgetAmount = 30;
    // }
    // if (midgetAmount > 2) {
    //     System.out.println("Midgets started the pump ");
    //     MegaphoneCall megaphoneCall = new MegaphoneCall(midgetAmount);
    // }
    System.out.println("Midgets calling for more midgets and greater meeting! ");

}
}
