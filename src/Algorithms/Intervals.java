package Algorithms;

import java.util.*;

public class Intervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> segs = new LinkedList<>();
        while (n-- > 0) {
            int l = sc.nextInt(), r = sc.nextInt();
            segs.add(new int[]{l, r});
        }

        segs.sort(Comparator.comparingInt(a -> a[1]));
        List<Integer> res = new LinkedList<>();
        int last = -1;

        for (int[] s : segs) {
            if (last < s[0]) {
                last = s[1];
                res.add(last);
            }
        }

        System.out.println(res.size());
        res.forEach(p -> System.out.print(p + " "));
    }
}