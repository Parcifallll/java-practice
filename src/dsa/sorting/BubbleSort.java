package dsa.sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort { // O(n^2), Big_Omega(n) - if there's a is_swapped flag for (almost) sorted arrays
    public static void sort(int[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            for (int j = 0; j < args.length - 1 - i; j++) {
                if (args[j] > args[j + 1]) {
                    int temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new Random().ints(10, 1, 10).toArray();
        sort(a);
        Arrays.stream(a).forEach(x -> System.out.printf("%d ", x));

        System.out.println(Arrays.equals(a, Arrays.stream(a).sorted().toArray()));


    }
}
