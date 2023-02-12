package src.collection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Scanner;



/*
 *  private double x;
 *  private Float y; //Значение поля должно быть больше -459, Поле не может быть null
 */




public class Coordinates {
    private double x;
    @NotNull
    @Min(-459)
    private Float y;

    public Coordinates(double x, Float y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates(){
        x=readX();
        y=readY();
    }

    private double readX(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x");
        double x = scanner.nextDouble();
        while (x<=-459){
            System.out.println("Enter x> -459");
            x = scanner.nextDouble();
        }
        return x;
    }

    private float readY(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter y");
        while (!scanner.hasNextFloat()) {
            System.out.println("Enter y");
            scanner.next();
        }
        return scanner.nextFloat();
    }

    public double getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return
                "x=" + x +
                ", y=" + y;
    }
    
}
