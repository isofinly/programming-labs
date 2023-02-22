package src.collection;

import org.jetbrains.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;
/*
 *  String name; //Поле не может быть null, Строка не может быть пустой
 *  Long practiceHours; //Поле может быть null
 *  Class for discipline
 *  @see LabWork
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
    public Discipline(){
       name=readName();
       practiceHours=readPracticeHours();
    }

    private String readName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of discipline");
        while (true){
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty");
            } else {
                return name;
            }
        }
    }
    private long readPracticeHours() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter practice hours of discipline");
        while (true){
            String practiceHours = scanner.nextLine();
            if (practiceHours.isEmpty()) {
                System.out.println("Practice hours cannot be empty");
            } else {
                return Long.parseLong(practiceHours);
            }
        }
    }


    @NotNull
    private final String name;
    public  @NotNull String getName() {
        return name;
    }
    
    @NotNull 
    private final Long practiceHours;
    public @NotNull Long getPracticeHours() {
        return practiceHours;
    }

    @Override
    public String toString() {
             return    "name='" + name + '\'' +
                ", practiceHours=" + practiceHours;
    }
}
