package Generics;

interface MinMax<T> {
    T getMax();
}

public class GenericInterface<T extends Comparable<T>> implements MinMax<T> {
    private T[] vals;

    public GenericInterface(T[] vals) {
        this.vals = vals;
    }

    @Override
    public T getMax() {
        T max = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(max) > 0) max = vals[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] vals1 = {1, 2, 3, 4};
        String[] vals2 = {"One", "Two", "Three"};
        GenericInterface<Integer> gn1 = new GenericInterface<>(vals1);
        GenericInterface<String> gn2 = new GenericInterface<>(vals2);
        System.out.println(gn1.getMax());
        System.out.println(gn2.getMax());


    }
}
