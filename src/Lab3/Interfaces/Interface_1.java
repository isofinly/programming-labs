package Lab3.Interfaces;//import Lab3.Persons.Mood;
//import Lab3.Persons.PersonState;

import Lab3.Persons.Mood;
import Lab3.Persons.PersonState;

public interface Interface_1 {
    PersonState getState();
    Mood getMood();
    int getAge();
    void setState(PersonState newState);
    void setMood(Mood newMood);
    void die();
}
