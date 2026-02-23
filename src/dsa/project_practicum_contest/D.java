package dsa.project_practicum_contest;

import java.io.*;
import java.util.*;

// вариация кузнечика на дин прог. Стоим на 0 клетке, прыгаем на 1 или 2. Последняя клетка считается всегда.
// на каждой клетке лежат веса, задача - собрать как можно больше. k раз можно прыгнуть на любое кол-во шагов.
public class D {
    static final long NEG = Long.MIN_VALUE / 4;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int k = fs.nextInt();

        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = fs.nextLong();
        }

        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], NEG);
        }

        dp[0][0] = 0;

        long[] best = new long[k + 1];
        Arrays.fill(best, NEG);
        best[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                long ans = NEG;

                // шаг с i-1
                if (dp[i - 1][j] != NEG) {
                    ans = Math.max(ans, dp[i - 1][j] + a[i]);
                }

                if (i >= 2 && dp[i - 2][j] != NEG) {
                    ans = Math.max(ans, dp[i - 2][j] + a[i]);
                }

                if (i != n && j > 0 && best[j - 1] != NEG) {
                    ans = Math.max(ans, best[j - 1]);
                }

                dp[i][j] = ans;
            }

            for (int j = 0; j <= k; j++) {
                best[j] = Math.max(best[j], dp[i][j]);
            }
        }

        long result = NEG;
        for (int j = 0; j <= k; j++) {
            result = Math.max(result, dp[n][j]);
        }

        System.out.println(result);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}