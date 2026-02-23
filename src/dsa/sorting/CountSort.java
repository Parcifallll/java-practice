package dsa.sorting;

import java.util.Arrays;
import java.util.Random;

/*
    for decimals (or chars as ASCII codes) only
    effective only if n<10^5 and N < K, because of aux space
    O(n+k) time and space
 */
public class CountSort {
    private static void sort(int[] a) {
        int max = 0;
        for (int x : a) {
            if (x > max) max = x;
        }
        int[] count = new int[max + 1];

        for (int x : a) {
            count[x]++;
        }

        int j = 0;
        for (int i = 0; i < a.length; i++) {
            while (count[j] == 0) j++;
            a[i] = j;
            count[j]--;
        }

    }

    public static void main(String[] args) {
        int[] a = new Random().ints(40, 65, 90).toArray();
        sort(a);
        System.out.println(Arrays.equals(a, Arrays.stream(a).sorted().toArray()));
    }
}
