package dsa.contests.contest1;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // \n
        String s = scanner.nextLine();

        // AABCC -> ACCA
        int[] a = new int[26];
        for (int i = 0; i < n; i++) {
            a[s.charAt(i) - 'A']++;
        }

        StringBuilder sb = new StringBuilder();
        char mid = ' ';
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if (a[i] % 2 != 0 && !flag) {
                mid = (char) (i + 'A');
                flag = true; // found odd element
            }
            for (int j = 0; j < a[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        int k = 0;
        if (flag){
            sb.append(mid);
            k = 1;
        }
        for (int i = sb.length() - 1 - k; i >= 0; i--){
            sb.append(sb.charAt(i));
        }

        System.out.println(sb);

    }
}
