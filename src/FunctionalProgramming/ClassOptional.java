package FunctionalProgramming;

import java.util.Objects;
import java.util.Optional;
public class ClassOptional {
    public static void main(String[] args) {
        Car c1 = new Car(10, "str");
        Car c2 = new Car(10, "str");
        System.out.println(Optional.ofNullable(c1).equals(Optional.ofNullable(c2)));
    }
}

class Car {
    private int speed; //access modifier
    private String color;

    public Car(int speed, String color) {
        this.speed = speed;
        this.color = color;
    }


    public void setSpeed(int speed) { //setter
        if (speed >= 0) this.speed = speed;
        else throw new IllegalArgumentException("Speed can't be negative");
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) this.color = color;
        else throw new IllegalArgumentException("Invalid color");
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; //links are similar
        if (!(obj instanceof Car)) return false; //always false
        Car car = (Car) obj;
        return (this.speed == car.speed && Objects.equals(this.color, car.color));
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, color);
        /* INITIALLY
        return 31 * AN_OBJECT.hashCode() + PRIMITIVE
        remember to check (color != null ? color.hashCode() : 0);
        there is the null-check in Objects.hash
         */
    }
}