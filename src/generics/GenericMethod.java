package generics;

import java.util.Objects;

public class GenericMethod {
    private static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (T t : y) {
            return (Objects.equals(t, y));
        }
        return false;
    }

    public static void main(String[] args) {
        String str = null;
        String[] s = {null};
        System.out.println(isIn(str, s));
    }
}
//These generics guarantee the compatibility of T and V types
