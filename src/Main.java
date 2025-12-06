import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] l = new long[n + 1];
        long[] r = new long[n + 1];
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            l[i] = sc.nextLong();
            r[i] = sc.nextLong();
            a[i] = sc.nextLong();
        }
        long[] left = new long[n + 1];
        left[1] = a[1];
        for (int i = 2; i <= n; i++) {
            left[i] = a[i] + Math.min(l[i], left[i - 1]);
        }
        long[] right = new long[n + 1];
        right[n] = a[n];
        for (int i = n - 1; i >= 1; i--) {
            right[i] = a[i] + Math.min(r[i], right[i + 1]);
        }
        long ans = 0;
        for (int k = 1; k <= n; k++) {
            long cur = a[k];
            if (k > 1) {
                cur += Math.min(l[k], left[k - 1]);
            }
            if (k < n) {
                cur += Math.min(r[k], right[k + 1]);
            }
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }
}