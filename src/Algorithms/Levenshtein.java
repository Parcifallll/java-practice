package Algorithms;

import java.util.*;

public class Levenshtein {
    public static int minOp(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int deleteOp = prev[j] + 1;
                    int insertOp = curr[j - 1] + 1;
                    int replaceOp = prev[j - 1] + 1;
                    curr[j] = Math.min(Math.min(deleteOp, insertOp), replaceOp);
                }
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        int minOps = Integer.MAX_VALUE;
        List<String> resultWords = new ArrayList<>();

        if (n == 0) minOps = 0;
        else {
            for (String word : words) {
                int ops = minOp(word, target);
                if (ops < minOps) {
                    minOps = ops;
                    resultWords.clear();
                    resultWords.add(word);
                } else if (ops == minOps) resultWords.add(word);
            }
        }

        int k = resultWords.size();
        System.out.println("Most similar words = " + k);
        if (k == 0) System.out.print("Minimal operations needed = " + minOps);
        else {
            System.out.println("Minimal operations needed = " + minOps);
            for (int i = 0; i < k - 1; i++) System.out.println(resultWords.get(i));
            System.out.print(resultWords.get(k - 1));
        }
    }
}