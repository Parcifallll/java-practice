package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class Coins {
    public static final int MIN = -100_000_000;
    private static int[] table(Scanner scanner, int n, int m, int[][] c) {
        int stX = -1, stY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String s = scanner.next();
                if (s.equals("S")) {
                    c[i][j] = 0;
                    stX = i;
                    stY = j;
                } else {
                    c[i][j] = Integer.parseInt(s);
                }
            }
        }
        return new int[]{stX, stY};
    }

    private static int[][] DP(int n, int m, int[][] c) {
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    dp[i][j] = MIN;
            }
        }
        dp[n - 1][m - 1] = c[n - 1][m - 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;
                int best = MIN;
                if (j + 1 < m && dp[i][j + 1] != MIN) {
                    best = Math.max(best, dp[i][j + 1]);
                }
                if (i + 1 < n && dp[i + 1][j] != MIN) {
                    best = Math.max(best, dp[i + 1][j]);
                }
                if (best != MIN) {
                    dp[i][j] = c[i][j] + best;
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] c = new int[n][m];

        int[] stPos = table(scanner, n, m, c);
        int stX = stPos[0], stY = stPos[1];

        int[][] dp = DP(n, m, c);

        ArrayList<int[]> path = new ArrayList<>();
        int x = stX, y = stY;
        path.add(new int[]{x, y});
        while (x != n - 1 || y != m - 1) {
            int rightVal = MIN;
            int downVal = MIN;


            if (y + 1 < m) {
                rightVal = dp[x][y + 1];
            }
            if (x + 1 < n) {
                downVal = dp[x + 1][y];
            }

            if (rightVal != MIN && rightVal >= downVal) {
                y++;
            } else if (downVal != MIN) {
                x++;
            } else {

                break;
            }
            path.add(new int[]{x, y});
        }

        System.out.println("Path:");
        for (int i = 0; i < path.size(); i++) {
            int[] coords = path.get(i);
            System.out.print("(" + coords[0] + "," + coords[1] + ")");
            if (i < path.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("Algorithms.Coins: " + dp[stX][stY]);
    }
}