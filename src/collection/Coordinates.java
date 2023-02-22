package src.collection;

import org.jetbrains.annotations.NotNull;import java.util.Scanner;

/*
 *  double x;
 *  Float y; //Значение поля должно быть больше -459, Поле не может быть null
 *  Class for coordinates
 */

public class Coordinates {
    private double x;
    @NotNull
    private Float y;

    public Coordinates(double x, Float y) {
        this.x = x;
        if (y <= -459){
            throw new IllegalArgumentException();
        }
        this.y = y;
    }
    public Coordinates(){
        x=readX();
        y=readY();
    }

    private double readX(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x of type: double");
        double x = scanner.nextDouble();
        while (x<=-459){
            System.out.println("Enter x> -459 of type: double");
            x = scanner.nextDouble();
        }
        return x;
    }

    private float readY(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter y of type: float");
        while (!scanner.hasNextFloat()) {
            System.out.println("Enter y of type: float");
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
