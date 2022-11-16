package Lab3.Persons;

import Lab3.Interfaces.Interface_1;

public abstract class Person implements Interface_1 {
    private String Name;
    private int Age;
    private Mood PersonMood;
    private PersonState State;

    public Person(String name, int age, Mood mood, PersonState state) {
        Name = name;
        Age = age;
        PersonMood = mood;
        State = state;
    }

    public final PersonState getState() {
        return this.State;
    }

    public final Mood getMood() {
        return this.PersonMood;
    }

    public final String getName() {
        return this.Name;
    }

    public final int getAge() {
        return this.Age;
    }

    public void setState(PersonState newState) {
        if (this.State == newState) {
            System.out.println(this.getName() + " is already " + this.getState().toString());
        } else State = newState;
    }

    public void setMood(Mood newMood) {
        PersonMood = newMood;
    }

    public final void die() {
        this.State = PersonState.DEAD;
    }



    public final void wakeUp() {
        if (State == PersonState.SLEEP) {
            State = PersonState.STAND;
        } else System.out.println(this.getName() + " can't wake up now!");
    }

}
