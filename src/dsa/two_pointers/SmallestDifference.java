package dsa.two_pointers;

public class SmallestDifference {
    public static int solve(int[] a, int[] b){
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < a.length && j < b.length){
            int diff = Math.abs(a[i] - b[j]);
            if (diff < min){
                min = diff;
            }

            if (a[i] < b[j]) i++; // move on a smaller pointer
            else j ++;
        }
        return min;
    }
}
