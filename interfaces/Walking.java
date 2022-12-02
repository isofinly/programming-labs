// package interfaces;

// import place.TypeOfPlaces;

// public interface Walking {
//     void walk(TypeOfPlaces typeOfPlaces);
// }


package interfaces;

import place.TypeOfPlaces;

public interface Walking {
    default void walk(Object name, TypeOfPlaces typeOfPlaces){

    };
}