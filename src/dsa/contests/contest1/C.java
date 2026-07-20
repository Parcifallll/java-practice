package dsa.contests.contest1;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int lo = 1, hi = n;

        while (lo < hi){ // lo = mid
            int mid = lo + (hi - lo) / 2 + 1;

            System.out.println(mid);
            System.out.flush();

            String c = scanner.next();
            if (c.equals("<")) hi = mid - 1;
            else lo = mid; // because of >= (not strict)
        }

        System.out.println("! " + lo);
        System.out.flush();
    }
}
