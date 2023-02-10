package src.collection;

import java.util.Date;
import java.util.Random;

import javax.validation.constraints.NotNull;

import org.jetbrains.annotations.Nullable;

import src.utils.*;

import src.collection.*;

public class LabWork implements Comparable <LabWork> {

    /**
     * @param id                       id of the lab work unique and automatically generated
     * @param name                     Name of the lab work != null
     * @param coordinates              Coordinates of the lab work != null
     * @param minimalPoint             Minimal point of the lab work != null
     * @param personalQualitiesMinimum Personal qualities minimum of the lab work (can be null)
     * @param personalQualitiesMaximum Personal qualities maximum of the lab work
     * @param difficulty               Difficulty of the lab work != null
     * @param discipline               Discipline of the lab work != null
     */
    public LabWork(@NotNull String name, @NotNull Coordinates coordinates, @NotNull Integer minimalPoint, @Nullable Integer personalQualitiesMinimum, long personalQualitiesMaximum, @NotNull Difficulty difficulty, @NotNull Discipline discipline) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("\u001B[31m Name cannot be empty");
        }

        if (minimalPoint <= 0) {
            throw new IllegalArgumentException("\u001B[31m Minimal point cannot be less than 0");
        }

        if (personalQualitiesMinimum <= 0) {
            throw new IllegalArgumentException("\u001B[31m Personal qualities minimum cannot be less than 0");
        }

        if (personalQualitiesMaximum <= 0) {
            throw new IllegalArgumentException("\u001B[31m Personal qualities maximum cannot be less than 0");
        }
        this.discipline = discipline;
        this.difficulty = difficulty;
        this.coordinates = coordinates;
        this.name = name;
        this.minimalPoint = minimalPoint;
//        this.creationDate = java.time.LocalDate.now();

        this.creationDate = new java.util.Date(((long) (Math.random() * System.currentTimeMillis())));


        this.id = IdGen.getNewId();
        this.personalQualitiesMaximum = personalQualitiesMaximum;
        this.personalQualitiesMinimum = personalQualitiesMinimum;
    }

    private int id;

    public int getId() {
        return id;
    }
    public int getIdRemainder() {
        return id % 5;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    private String name;

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    private Coordinates coordinates;

    public @NotNull Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(@NotNull Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @NotNull
    private Date creationDate;

    public @NotNull Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(@NotNull Date creationDate) {
        this.creationDate = creationDate;
    }

    @NotNull
    private Integer minimalPoint;

    public @NotNull Integer getMinimalPoint() {
        return minimalPoint;
    }

    public void setMinimalPoint(@NotNull Integer minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    @Nullable
    private Integer personalQualitiesMinimum;

    public @Nullable Integer getPersonalQualitiesMinimum() {
        return personalQualitiesMinimum;
    }

    public void setPersonalQualitiesMinimum(@Nullable Integer personalQualitiesMinimum) {
        this.personalQualitiesMinimum = personalQualitiesMinimum;
    }

    private long personalQualitiesMaximum;

    public long getPersonalQualitiesMaximum() {
        return personalQualitiesMaximum;
    }

    public void setPersonalQualitiesMaximum(long personalQualitiesMaximum) {
        this.personalQualitiesMaximum = personalQualitiesMaximum;
    }

    @NotNull
    private Difficulty difficulty;

    public @NotNull Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(@NotNull Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @NotNull
    private Discipline discipline;

    public @NotNull Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(@NotNull Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public int compareTo(LabWork o) {
        return 0;
    }

    @Override
    public String toString() {
        String info = "";
        info += "\u001B[32m Id: \u001B[0m" + id;
        info += "\n \u001B[32m Name: \u001B[0m" + name;
        info += "\n \u001B[32m Coordinates: \u001B[0m" + coordinates;
        info += "\n \u001B[32m Created \u001B[0m" + creationDate;
        info += "\n \u001B[32m MinimalPoint: \u001B[0m" + minimalPoint;
        info += "\n \u001B[32m PersonalQualitiesMinimum: \u001B[0m" + personalQualitiesMinimum;
        info += "\n \u001B[32m PersonalQualitiesMaximum: \u001B[0m" + personalQualitiesMaximum;
        info += "\n \u001B[32m Difficulty: \u001B[0m" + difficulty;
        info += "\n \u001B[32m Discipline: \u001B[0m" + discipline + "\n\n";
        return info;
    }


}
