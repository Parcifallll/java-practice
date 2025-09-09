package AbstractClasses;

abstract public class Amphibian {
    public void scream(){
        System.out.println("AAHHH");
    }
    abstract public void eat();
}

class Frog extends Amphibian{
    @Override
    public void eat() {
        System.out.println("gfg");
    }
}

