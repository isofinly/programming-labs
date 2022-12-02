package place;
import planets.*;
public class Home {

    private String name;
    private Planets planets;

    public Home(String name, Planets planets) {
        this.name = name;
        this.planets = planets;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Planets getPlanets() {
        return planets;
    }
    @Override
    public String toString() {
        return "Home called " + name + ", on planet: " + planets;
    }

    // private int numberOfFloors;
    // private FlowerBed flowerBed;
    // private String name;

    // @Override
    // public String toString() {
    //     return "красивый " + numberOfFloors
    //             + "-ухэтажный " + name + " с верандой и "
    //             + flowerBed.toString() + "\n";
    // }

    // public Home(int numberOfFloors, String name, FlowerBed flowerBed) {
    //     this.numberOfFloors = numberOfFloors;
    //     this.name = name;
    //     this.flowerBed = flowerBed;
    // }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;

    //     Home home = (Home) o;

    //     if (numberOfFloors != home.numberOfFloors) return false;
    //     if (name != null ? !name.equals(home.name) : home.name != null) return false;
    //     return flowerBed != null ? flowerBed.equals(home.flowerBed) : home.flowerBed == null;
    // }

    // @Override
    // public int hashCode() {
    //     int result = numberOfFloors;
    //     result = 31 * result + (name != null ? name.hashCode() : 0);
    //     result = 31 * result + (flowerBed != null ? flowerBed.hashCode() : 0);
    //     return result;
    // }
}
