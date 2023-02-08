package src.collection;

import org.jetbrains.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.validation.constraints.NotNull;

/*
 *  private String name; //Поле не может быть null, Строка не может быть пустой
 *  private Long practiceHours; //Поле может быть null
 */
public class Discipline {

    public Discipline(String name, @Nullable Long practiceHours) {
        this.name = name;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long minimumTimestamp = new Date(70, 0, 1).getTime();
        long maximumTimestamp = new Date().getTime();
        long randomTimestamp = minimumTimestamp + (long)(Math.random() * (maximumTimestamp - minimumTimestamp));
        this.practiceHours = practiceHours;
//        this.practiceHours = randomTimestamp;
//        String randomDateTime = formatter.format(new Date(randomTimestamp));
//        System.out.println(randomDateTime);

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
             return    "name='" + name + '\'' +
                ", practiceHours=" + practiceHours;
    }
}
