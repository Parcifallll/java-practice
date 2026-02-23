package dsa.sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort { // Big_Omega(n) for (almost) sorted arrays
    public static void sort(int[] a) { // the best among O(n^2) sorts, quick for small blocks (<50 el)
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;

            }
        }
    }

    public static void main(String[] args) {
        int[] a = new Random().ints(10, 1, 10).toArray();
        sort(a);
        System.out.println(Arrays.toString(Arrays.stream(a).toArray()));
    }
}

