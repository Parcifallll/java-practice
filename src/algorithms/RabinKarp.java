package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RabinKarp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = Integer.parseInt(br.readLine().trim());
        String pat = br.readLine();
        String txt = br.readLine();
        Search(txt, pat, mod);
    }

    private static void Search(String text, String pattern, int mod) {
        int n = text.length();
        int m = pattern.length();
        if (m == 0 || m > n) {
            System.out.println("Matches: ");
            System.out.println("Spurious hits: ");
            return;
        }

        int patHash = Hash(pattern, m, mod);
        int currentHash = Hash(text, m, mod);
        int pow = 1;

        for (int i = 0; i < m - 1; i++) {
            pow = (pow * 26) % mod;
        }

        ArrayList<Integer> matches = new ArrayList<Integer>();
        ArrayList<Integer> spurious = new ArrayList<Integer>();

        for (int start = 0; start <= n - m; start++) {
            if (currentHash == patHash) {
                if (text.substring(start, start + m).equals(pattern)) {
                    matches.add(start);
                } else {
                    spurious.add(start);
                }
            }

            if (start < n - m) {
                int subtract = (text.charAt(start) - 'a') * pow % mod;
                currentHash = (currentHash - subtract) % mod;
                if (currentHash < 0) currentHash += mod;
                currentHash = (currentHash * 26 % mod + (text.charAt(start + m) - 'a')) % mod;
            }
        }

        System.out.print("Matches: ");
        matches.forEach(index -> System.out.print(index + " "));
        System.out.println();

        System.out.print("Spurious hits: ");
        spurious.forEach(index -> System.out.print(index + " "));
    }

    private static int Hash(String s, int len, int mod) {
        int value = 0;
        for (int i = 0; i < len; i++) {
            value = ((value * 26) % mod + (s.charAt(i) - 'a')) % mod;
        }
        return value;
    }
}