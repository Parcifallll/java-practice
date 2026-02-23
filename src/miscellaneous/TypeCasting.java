package miscellaneous;

public class TypeCasting {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Animal animal1 = (Animal) cat1; //upcasting - not necessary to make it explicit
        Animal cat2 = new Cat(); //the same in one line

        Animal animal2 = new Cat();
        if (animal2 instanceof Cat) { //always to check
            Cat cat3 = (Cat) animal2; //downcasting - always explicit
        }
    }
}

class Animal{}
class Cat extends Animal {}