package dsa.sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min_id = i;

            for (int j = i; j < a.length; j++) {
                if (a[j] < a[min_id]) min_id = j;
            }

            int temp = a[i];
            a[i] = a[min_id];
            a[min_id] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new Random().ints(10, 1, 10).toArray();
        sort(a);
        // Arrays.stream(a).forEach(x -> System.out.printf("%d ", x));

        System.out.println(Arrays.equals(a, Arrays.stream(a).sorted().toArray()));
    }
}
