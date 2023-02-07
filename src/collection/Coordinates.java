package src.collection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



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
