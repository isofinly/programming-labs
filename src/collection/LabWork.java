package src.collection;

import java.util.*;

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
    public LabWork(@NotNull String name, @NotNull Coordinates coordinates, @NotNull Integer minimalPoint,
                   @Nullable Integer personalQualitiesMinimum, long personalQualitiesMaximum,
                   @NotNull Difficulty difficulty, @NotNull Discipline discipline) {
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

    public LabWork(int id) {
        LabWork labWork = new LabWork();
        this.id = id;
        name = labWork.getName();
        coordinates = labWork.getCoordinates();
        minimalPoint = labWork.getMinimalPoint();
        personalQualitiesMinimum = labWork.getPersonalQualitiesMinimum();
        personalQualitiesMaximum = labWork.getPersonalQualitiesMaximum();
        difficulty = labWork.getDifficulty();
        discipline = labWork.getDiscipline();
        creationDate = labWork.getCreationDate();
    }

    public LabWork() {

        Scanner read = new Scanner(System.in);
        Discipline discipline;
        Difficulty difficulty;
        String name = "";
        long personalQualitiesMaximum;
        int personalQualitiesMinimum;
        int minimalPoint;
        float y;
        double x;

        while (true) {
            System.out.println("\u001B[34m Enter name: ");
            name = read.nextLine();
            if (!name.isEmpty()) {
                break;
            }
        }
        setName(name);
        System.out.println("\u001B[34m Enter coordinates: ");

        while (true) {
            System.out.println("\u001B[34m Enter x: ");
            try {
                x = Double.parseDouble(read.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("\u001B[31m Invalid number format.");
            }
        }

        while (true) {
            System.out.println("\u001B[34m Enter y: ");
            try {
                y = Float.parseFloat(read.nextLine());
                if (y > -459) {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("\u001B[31m Invalid number format.");
            }
        }
        creationDate = new java.util.Date(((long) (Math.random() * System.currentTimeMillis())));
        setCreationDate(creationDate);
        coordinates = new Coordinates(x, y);
        setCoordinates(coordinates);
        while (true) {
            System.out.println("\u001B[34m Enter minimal point: ");
            try {
                minimalPoint = Integer.parseInt(read.nextLine());
                if (minimalPoint > 0) {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("\u001B[31m Invalid number format.");
            }
        }
        setCreationDate(new Date());
        setMinimalPoint(minimalPoint);
        while (true) {
            System.out.println("\u001B[34m Enter personal qualities minimum: ");
            try {
                personalQualitiesMinimum = Integer.parseInt(read.nextLine());
                if (personalQualitiesMinimum > 0) {
                    setPersonalQualitiesMinimum(personalQualitiesMinimum);
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("\u001B[31m Invalid number format.");
            }
        }
        while (true) {
            System.out.println("\u001B[34m Enter personal qualities maximum: ");
            try {
                personalQualitiesMaximum = Long.parseLong(read.nextLine());
                if (personalQualitiesMaximum > 0) {
                    setPersonalQualitiesMaximum(personalQualitiesMaximum);
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("\u001B[31m Invalid number format.");
            }
        }
        while (true) {
            System.out.println("\u001B[34m Enter difficulty: ");
            try {
                System.out.println("\u001B[34m Enter one of these types of difficulty:  \u001B[0m");
                System.out.println(Difficulty.nameList());
                String input = read.nextLine().trim().toUpperCase();
                difficulty = Difficulty.valueOf(input);
                setDifficulty(difficulty);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println("\u001B[31m Invalid difficulty type.");
            }
        }

        while (true) {
            System.out.println("\u001B[34m Enter discipline name: ");
            try {
                String disciplineName = read.nextLine();
                long selfStudyHours = 0;
                while (selfStudyHours == 0) {
                    System.out.println("\u001B[34m Enter self study hours: ");
                    try {
                        selfStudyHours = Long.parseLong(read.nextLine());
                    } catch (NumberFormatException ex) {
                        System.out.println("\u001B[31m Invalid number format.");
                    }
                }
                discipline = new Discipline(disciplineName, selfStudyHours);
                setDiscipline(discipline);
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println("\u001B[31m Invalid discipline name.");
            }
        }

        try {

//                labWork.add(new LabWork(name, coordinates, minimalPoint, personalQualitiesMinimum, personalQualitiesMaximum, difficulty, discipline));
            System.out.println("\u001B[34m Element added.");
        } catch (IllegalArgumentException ex) {
            System.out.println("\u001B[31m Invalid argument.");
        }

    }

//        System.out.println();
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter name: ");
//        name = in.nextLine();
//        while (true){
//            System.out.println("Enter name: ");
//            name = in.nextLine();
//            if (name.isEmpty()){
//                System.out.println("Name cannot be empty");
//            } else {
//                break;
//            }
//        }
//        System.out.println("Enter coordinates: ");
//        coordinates = new Coordinates();
//        System.out.println("Enter minimal point: ");
//        minimalPoint = in.nextInt();
//        while (true){
//            System.out.println("Enter minimal point: ");
//            minimalPoint = in.nextInt();
//            if (minimalPoint <= 0){
//                System.out.println("Minimal point cannot be less than 0");
//            } else {
//                break;
//            }
//        }
//        System.out.println("Enter personal qualities minimum: ");
//        personalQualitiesMinimum = in.nextInt();
//        while (true){
//            System.out.println("Enter personal qualities minimum: ");
//            personalQualitiesMinimum = in.nextInt();
//            if (personalQualitiesMinimum <= 0){
//                System.out.println("Personal qualities minimum cannot be less than 0");
//            } else {
//                break;
//            }
//        }
//        System.out.println("Enter personal qualities maximum: ");
//        personalQualitiesMaximum = in.nextLong();
//        while (true){
//            System.out.println("Enter personal qualities maximum: ");
//            personalQualitiesMaximum = in.nextLong();
//            if (personalQualitiesMaximum <= 0){
//                System.out.println("Personal qualities maximum cannot be less than 0");
//            } else {
//                break;
//            }
//        }
//        System.out.println("Enter difficulty: ");
//        difficulty = Difficulty.valueOf(in.next());
//        System.out.println("Enter discipline: ");
//        discipline = new Discipline();
//        creationDate = new java.util.Date(((long) (Math.random() * System.currentTimeMillis())));
//        id = IdGen.getNewId();
//    }

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

    /*
     This implementation first compares the difficulty of the two LabWork objects,
     and returns a negative integer, zero, or a positive integer as this LabWork's difficulty is less than,
     equal to, or greater than the other LabWork's difficulty.
     *
     If the difficulties are equal, it then compares the minimalPoint,
     and if the minimalPoints are equal, it compares the names.
     *
     the LabWork objects will be sorted first by difficulty, then by minimalPoint, and finally by name.
     */
    @Override
    public int compareTo(LabWork other) {
//        if (this.difficulty != other.difficulty) {
//            return this.difficulty.ordinal() - other.difficulty.ordinal();
//        }
        if (!Objects.equals(this.minimalPoint, other.minimalPoint)) {
            return this.minimalPoint - other.minimalPoint;
        }
        return this.name.compareTo(other.name);
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
