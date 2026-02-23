package abstract_classes;


public class Rectangle extends Figure {
    @Override //ctrl+o or ALT+INSERT (for auto-completion)
    void area() {
        System.out.println(getDim1()*getDim2());
    }
}
