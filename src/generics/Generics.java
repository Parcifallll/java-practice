package generics;

import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Apple apple1 = new Apple("green apple");
        Apple apple2 = new Apple("red apple");
        Fruit fruit = new Fruit("fruit");
        Bag<Fruit> bag = new Bag<Fruit>(List.of(apple1, apple2, fruit));
        bag.add(apple2);


    }
}

class Bag<T extends Fruit> {
    List<T> list;

    public Bag(List<T> list) {
        this.list = list;
    }

    public void add(T fruit) {
        list.add(fruit);
    }

}

class Fruit {
    private String fruit;

    public Fruit(String fruit) {
        this.fruit = fruit;
    }

    public void show() {
        System.out.println(fruit.getClass().getName()); //getClass returns an object, getName returns a string
    }
}

class Apple extends Fruit{
    private String name;
    public Apple(String name){
        super(name);
    }
}