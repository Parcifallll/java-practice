package dsa.contests.contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static int solve(int[] a, int x) {
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (Math.abs(a[mid] - x) < min) {
                res = a[mid];
                min = Math.abs(a[mid] - x);
            }
            else if (Math.abs(a[mid] - x) == min){
                if (a[mid] < res){
                    res = a[mid];
                }
            }

            if (a[mid] > x) hi = mid - 1;
            else if (a[mid] < x) lo = mid + 1;
            else if (a[mid] == x) return a[mid];
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(st.nextToken());
            System.out.println(solve(a, x));
        }
    }
}