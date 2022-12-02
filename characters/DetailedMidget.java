package characters;

import interfaces.Sitting;
import place.TypeOfPlaces;
import planets.Planets;

public class DetailedMidget extends MainCharacters implements Sitting {
    private int weight;
    private String colorOfHead;
    private String hair;
    private String eyes;
    boolean eyebrows;
    private String cloths;
    private String faceView;
    private String name;


    @Override
    public String toString() {
        return name + " - in weight of " + weight + " kg " +
                colorOfHead + hair + "\n" + "His eyes " + eyes + faceView + "\n is dressed in" + cloths;
    }

    public DetailedMidget(String name, int weight, String colorOfHead, String hair, String eyes, boolean eyebrows, String cloths, Planets planets, TypeOfPlaces typeOfPlaces) {
        super(name,planets,typeOfPlaces);
        this.name = name;
        this.colorOfHead = colorOfHead;
        this.eyes = eyes;
        this.hair = hair;
        this.weight = weight;
        this.eyebrows = eyebrows;
        this.cloths = cloths;
        if (eyebrows == false)
        // к тому же бровей у него не было и лицо его казалось очень веселым и добрым
            this.faceView = " he did not have eyebrows and his face seemed very cheerful and kind";
            // Брови на месте, лицо обычное
        else this.faceView = "Eyebrows are on the right spot and face is common";
        // толстенький весом в 
        System.out.println( name + " - fatty in weight of " + weight + "kg " +
                colorOfHead + hair + "\n" + "His eyes were " + eyes + faceView + "\n is dressed in " + cloths);
    }

    @Override
    public void sit(TypeOfPlaces typeOfPlaces) {
        if (typeOfPlaces == TypeOfPlaces.VERANDA)
            System.out.println( name + " sat on " + typeOfPlaces.getName() + " at table and did several things at once");

    }
}

