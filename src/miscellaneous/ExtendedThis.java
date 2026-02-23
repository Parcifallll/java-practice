package miscellaneous;

class Box_2 {
    int a, b, c; //cube metrics

    Box_2(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Box_2(int a) {
        this(a, a, a);
    }

    Box_2() {
        this(0); //or this(0, 0, 0);
    }
}

public class ExtendedThis{
    public static void main(String[] args) {
        Box_2 b1 = new Box_2(1, 1, 1);
        Box_2 b2 = new Box_2(1);
        Box_2 b3 = new Box_2();
    }
}

