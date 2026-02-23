package generics;

public class GenericConstructor {
    public static void main(String[] args) {
        GetFruit getFruit = new GetFruit(new Apple("apple"));
        getFruit.show();
    }

}

class GetFruit {
    private Fruit fruit;

    public <T extends Fruit> GetFruit(T fruit) {
        this.fruit = fruit;
    }
    public<S extends Fruit> void show(){
        System.out.println(fruit.getClass().getName());
    }

}