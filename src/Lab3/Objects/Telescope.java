package Lab3.Objects;

import Lab3.Persons.Person;

public class Telescope extends Artificial {
    private boolean IsOccupied;
    private Person OccupiedBy;
    // Magnification of the telescope
    private final Integer Magnification;
    // Scope length in meters
    private final Integer Length;
    public Telescope(State currentState, Material material, Integer magnification, Integer length) {
        super(currentState, material);
        Magnification = magnification;
        Length = length;
    }
    // set telescope as occupied by some person

    public final boolean isOccupied() {
        return IsOccupied;
    }

    public final Person getPerson() {
        return OccupiedBy;
    }
    public final Integer getAuthor() {
        return Magnification;
    }

    public final Integer getName() {
        return Length;
    }
    public final void setOccupied(Person person, boolean isOccupied) {
        if (IsOccupied != isOccupied) {
            IsOccupied = isOccupied;
            OccupiedBy = person;
        } else {
            System.out.println("The telescope is already " + (isOccupied ? "occupied" : "free"));
        }
    }

    @Override
    public int hashCode() {
        return (IsOccupied ? 1 : 0) * 31 + OccupiedBy.hashCode();
    }

    @Override
    public String toString() {
        return "Telescope {" +
                "Material=" + this.getMaterial().toString() +
                ", State=" + this.getState().toString() +
                ", IsOccupied=" + IsOccupied +
                ", OccupiedBy=" + OccupiedBy +
                ", Magnification=" + Magnification +
                ", Length=" + Length +
                '}';
    }
}

