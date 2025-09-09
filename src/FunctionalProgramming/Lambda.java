package FunctionalProgramming;

import java.util.function.BiPredicate;
import java.util.Objects;

public class Lambda {
    public static void main(String[] args) {
        Cup cup = new Cup("Original");
        cup.setBlue.run();
        cup.show();
    }
}

class Cup {
    private String color;

    public Cup(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    Runnable setBlue = () -> {
        color = "New"; // changed a field in the class
    };

    public void show() {
        System.out.println(color);
    }
}
