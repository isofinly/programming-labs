package Item;

public class Binocularus extends Item{
    // binocularus for looking at the distance
    private int distance;
    private int magnification;

    public Binocularus(String name, int distance, int magnification) {
        super(name);
        this.distance = distance;
        this.magnification = magnification;
    }
    public void lookAtDistance(){
        System.out.println("Binocularus are looking at the distance" + distance + "meters");
    }
    public void magnification(){
        System.out.println("Binocularus are magnifying the distance" + magnification + "times");
    }
    
}
