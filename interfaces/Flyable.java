package interfaces;

import planets.*;

public interface Flyable {
    
    // default String Planets() {
    //     return "EARTH";
    // }

    void ascend(Object object, int speed, Planets planets) throws Exception;
    void descend(Object object, int speed, Planets planets) throws Exception;
}
