package src.CollectionClasses;

import javax.validation.constraints.NotNull;

/*
 *  private String name; //Поле не может быть null, Строка не может быть пустой
 *  private Long practiceHours; //Поле может быть null
 */
public class Discipline {

    public Discipline(String name, Long practiceHours) {
        if (name.isEmpty()){
            throw new IllegalArgumentException("Name can't be empty");
        }
        this.name = name;
        this.practiceHours = practiceHours;
    }

    @NotNull
    private String name;
    public  @NotNull String getName() {
        return name;
    }
    
    @NotNull 
    private Long practiceHours;
    public @NotNull Long getPracticeHours() {
        return practiceHours;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", practiceHours=" + practiceHours +
                '}';
    }
}
