package dsa.sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    private static int[] aux;

    public static void sort(int[] a) {
        aux = new int[a.length];
        sorting(a, 0, a.length - 1);
    }

    // 3 2 5 6 4
    private static void sorting(int[] a, int lo, int hi) { // recursive descending merge sorting
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sorting(a, lo, mid); // left part
        sorting(a, mid + 1, hi); // right part
        merge(a, lo, mid, hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo; // left pointer
        int j = mid + 1; // right pointer
        // int[] aux = Arrays.copyOf(a, hi - lo + 1);
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) { // no elements on the left
                a[k] = aux[j];
                j++;
            } else if (j > hi) { // no elements on the right
                a[k] = aux[i];
                i++;
            } else if (aux[i] > aux[j]) {
                a[k] = aux[j];
                j++;
            } else if (aux[i] <= aux[j]) {
                a[k] = aux[i];
                i++;
            }
        }

    }

    public static void main(String[] args) {
        int[] a = new Random().ints(10, 1, 10).toArray();
        sort(a);
        System.out.println(Arrays.equals(a, Arrays.stream(a).sorted().toArray()));
    }
}
