package interfaces;

import planets.*;

public interface Flyable {
    
    // default String Planets() {
    //     return "EARTH";
    // }

    void ascend(int speed, Planets planets) throws Exception;
    void descend(int speed, Planets planets) throws Exception;
}
