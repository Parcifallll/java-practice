package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThreePointers {
    record Pointers(int a, int b, int c, int diff) {
    }

    private static Pointers Find(int[] arrA, int[] arrB, int[] arrC) {
        int ptrA = 0, ptrB = 0, ptrC = 0;
        int bestA = 0, bestB = 0, bestC = 0;
        int minDiff = Integer.MAX_VALUE;

        while (ptrA < arrA.length && ptrB < arrB.length && ptrC < arrC.length) {
            int a = arrA[ptrA], b = arrB[ptrB], c = arrC[ptrC];
            int minVal = a;
            int maxVal = a;
            if (b < minVal) minVal = b;
            else if (b > maxVal) maxVal = b;
            if (c < minVal) minVal = c;
            else if (c > maxVal) maxVal = c;
            int curDiff = maxVal - minVal;
            if (curDiff < minDiff) {
                minDiff = curDiff;
                bestA = a;
                bestB = b;
                bestC = c;
            }
            if (a == minVal) ptrA++;
            else if (b == minVal) ptrB++;
            else ptrC++;
        }
        return new Pointers(bestA, bestB, bestC, minDiff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine().trim());
        int[] arrA = new int[n1];
        StringTokenizer st = new StringTokenizer(br.readLine()); //ruined my solution for contest! always use this combo for quick-contests
        for (int i = 0; i < n1; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        int n2 = Integer.parseInt(br.readLine().trim());
        int[] arrB = new int[n2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        int n3 = Integer.parseInt(br.readLine().trim());
        int[] arrC = new int[n3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n3; i++) {
            arrC[i] = Integer.parseInt(st.nextToken());
        }

        Pointers result = Find(arrA, arrB, arrC);
        System.out.printf("Numbers = %s %s %s%n", result.a, result.b, result.c);
        System.out.println("Result = " + result.diff);
    }
}