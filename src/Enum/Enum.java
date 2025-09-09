package Enum;

public class Enum {
    public static void main(String[] args) {
        for (Genre genre : Genre.values()) { //traverse
            System.out.println("Original name: " + genre.name() + ", " + //non-overridable final method name()
                    "toString(): " + genre.toString()); //overridable method Object.toString()
            //note: enum.toString() is redundant, because toString() is called automatically
        }
    }
}

enum Genre {
    HORROR, DRAMA, TRILLER;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

}
