package src.CollectionClasses;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.jetbrains.annotations.Nullable;

import src.utils.*;

public class LabWork implements Comparable<LabWork> {

    /**
     * @param id                        id of the lab work unique and automatically generated
     * @param name                      Name of the lab work != null
     * @param coordinates               Coordinates of the lab work != null
     * @param minimalPoint              Minimal point of the lab work != null
     * @param personalQualitiesMinimum  Personal qualities minimum of the lab work (can be null)
     * @param personalQualitiesMaximum  Personal qualities maximum of the lab work
     * @param difficulty                Difficulty of the lab work != null  
     * @param discipline                Discipline of the lab work != null 
     */
    public LabWork(@NotNull String name, @NotNull Coordinates coordinates, @NotNull Integer minimalPoint, @Nullable Integer personalQualitiesMinimum, long personalQualitiesMaximum, @NotNull Difficulty difficulty, @NotNull Discipline discipline) {
        if (name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (minimalPoint <= 0){
            throw new IllegalArgumentException("Minimal point cannot be less than 0");
        }

        if (personalQualitiesMinimum <= 0){
            throw new IllegalArgumentException("Personal qualities minimum cannot be less than 0");
        }

        if (personalQualitiesMaximum <= 0){
            throw new IllegalArgumentException("Personal qualities maximum cannot be less than 0");
        }
        this.discipline = discipline;
        this.difficulty = difficulty;
        this.coordinates = coordinates;
        this.name = name;
        this.minimalPoint = minimalPoint;
        this.creationDate = java.time.LocalDate.now();
        this.id = IdGen.getNewId();
        this.personalQualitiesMaximum = personalQualitiesMaximum;
        this.personalQualitiesMinimum = personalQualitiesMinimum;
    }

    /**
     * @param id id of the lab work
     */
    private int id;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set automatically generated
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name of the lab work cannot be null
     */
    @NotNull 
    private String name;

    /**
     * @return the name
     */
    public @NotNull String getName() {
        return name;
    }

    /**
     * @param coordinates of the lab work cannot be null
     */
    @NotNull
    private Coordinates coordinates;

    /**
     * @return the coordinates
     */
    public @NotNull Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @param creationDate of the lab work cannot be null
     */
    @NotNull
    private java.time.LocalDate creationDate;

    /**
     * @return the creationDate
     */
    public @NotNull java.time.LocalDate getCreationDate() {
        return creationDate;
    }
    
    /**
     *  @param minimalPoint of the lab work cannot be null
     */
    @NotNull
    private Integer minimalPoint;

    /**
     * @return the minimalPoint
     */
    public @NotNull Integer getMinimalPoint() {
        return minimalPoint;
    }

    /**
     *  @param personalQualitiesMinimum of the lab work can be null
     */
    @Nullable
    private Integer personalQualitiesMinimum;

    /**
     * @return the personalQualitiesMinimum
     */
    public @Nullable Integer getPersonalQualitiesMinimum() {
        return personalQualitiesMinimum;
    }

    /**
     * @param personalQualitiesMaximum of the lab work
     */
    private long personalQualitiesMaximum;

    /**
     * @return the personalQualitiesMaximum
     */
    public long getPersonalQualitiesMaximum() {
        return personalQualitiesMaximum;
    }
     
    /**
     * @param difficulty of the lab work cannot be null
     */
    @NotNull
    private Difficulty difficulty;

    /**
     * @return the difficulty
     */
    public @NotNull Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * @param discipline of the lab work cannot be null
     */
    @NotNull
    private Discipline discipline;

    /**
     * @return the discipline
     */
    public @NotNull Discipline getDiscipline() {
        return discipline;
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
        info += " (Created " + creationDate + ")";
        info += "\n \u001B[32m MinimalPoint: \u001B[0m" + minimalPoint;
        info += "\n \u001B[32m PersonalQualitiesMinimum: \u001B[0m" + personalQualitiesMinimum;
        info += "\n \u001B[32m PersonalQualitiesMaximum: \u001B[0m" + personalQualitiesMaximum;
        info += "\n \u001B[32m Difficulty: \u001B[0m" + difficulty;
        info += "\n \u001B[32m Discipline: \u001B[0m" + discipline + "\n\n";
        return info;
    }
}
