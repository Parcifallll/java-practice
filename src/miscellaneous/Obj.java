package miscellaneous;

import java.util.Objects;

public class Obj {
    public static void main(String[] args) {
        Car car = new Car(100, "Black");
        System.out.println(car);
    }
}

class Car {
    private int speed; //access modifier
    private String color;

    public Car(int speed, String color) {
        this.speed = speed;
        this.color = color;
    }

    public int getSpeed() { //getter
        return speed;
    }

    public String getColor() {
        return color;
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
        return "miscellaneous.Car{" +
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
