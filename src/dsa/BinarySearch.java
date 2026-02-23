package dsa;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch { // partial case of the problem: f(n) -> bool, where f(n) is monotonous
    public static int search(int[] a, int k) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > k) hi = mid - 1;
            else if (a[mid] < k) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new Random().ints(20, 1, 10).toArray();
        Arrays.sort(a);
        System.out.println(search(a, 2));
        for (int x : a) System.out.print(x + " ");
    }

}
