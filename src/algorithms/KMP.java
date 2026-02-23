package algorithms;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder pattern = new StringBuilder(br.readLine());
        StringBuilder txt = new StringBuilder(br.readLine());
        int[] patternPrefix = Prefix(pattern);
        StringBuilder comb = new StringBuilder(pattern).append("*").append(txt);
        int[] combPrefix = Prefix(comb);

        System.out.print("Prefix template: ");
        for (int i : patternPrefix) System.out.print(i + " ");
        System.out.println();
        System.out.print("Prefix function: ");
        for (int i : combPrefix) System.out.print(i + " ");
        System.out.println();
        List<Integer> matches = find(pattern, txt);
        System.out.print("Matches: ");
        for (int match : matches) System.out.print(match + " ");
    }

    private static int[] Prefix(StringBuilder s) {
        int n = s.length();
        int[] pi = n == 0 ? new int[0] : new int[n];
        int i = 1;
        while (i < n) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j - 1];
            pi[i] = (s.charAt(i) == s.charAt(j)) ? j + 1 : j;
            i++;
        }
        return pi;
    }

    private static List<Integer> find(StringBuilder pattern, StringBuilder txt) {
        StringBuilder comb = new StringBuilder();
        comb.append(pattern).append('*').append(txt);
        int[] pi = Prefix(comb);
        ArrayList<Integer> matches = new ArrayList<Integer>();
        int pLen = pattern.length();
        int combLen = comb.length();

        for (int idx = pLen + 1; idx < combLen; idx++) {
            if (pi[idx] == pLen) matches.add(idx - pLen * 2);
        }
        return matches;
    }
}