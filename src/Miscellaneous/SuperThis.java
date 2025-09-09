package Miscellaneous;

class Box {
    private int i;
    private int j;
    private int k;

    public Box(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    Box(Box b) {
        this.i = b.i;
        this.j = b.j;
        this.k = b.k;
    }


}

class BoxW extends Box {
    private int w;

    BoxW(int i, int j, int k, int w) {
        super(i, j, k);
        this.w = w;
    }

    BoxW(BoxW b) {
        super(b);
        this.w = b.w;

    }
}