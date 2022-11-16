package Lab3.Persons;

import java.util.Arrays;

public class Policeman extends Person {
    private String Rank;
    private int PageCount;
    private String[] Crimes;

    public Policeman(Mood mood, PersonState state, String rank, String[] crimes) {
        super("aboba", 0, mood, state);
        Rank = rank;
        Crimes = crimes;
    }

    public final String getRank() {
        return Rank;
    }

    public final String[] getCrimes() {
        return Crimes;
    }

    public final int getNumberOfPages() {
        return PageCount;
    }

    public void arrest(Person person) {
        this.setState(PersonState.ARRESTED);
        if (this.getState() == PersonState.ARRESTED) {
            person.setMood(Mood.ANGY);
            System.out.println(super.getName() + " arrested " + person.getName() + " for " + Arrays.toString(this.getCrimes()));
        }
    }
    public void bonk(Person person) {
        this.setState(PersonState.BONKED);
        if (this.getState() == PersonState.BONKED) {
            person.setMood(Mood.CHASTE);
            System.out.println( super.getName() + " bonked " + person.getName() + " and now " + person.getName() + " is " + person.getMood() + " " + person.getState());
        }
    }
}
