package algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class Summ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(scanner.nextInt());

        int l = 0, sum = 0;
        int maxSum = -1, st = -1;
        int minLen = 1_000_000;

        for (int r = 0; r < n; r++) {
            sum += arr.get(r);
            while (sum >= k) {
                int len = r - l + 1;
                boolean upd = switch (Integer.compare(len, minLen)) {
                    case -1 -> true;
                    case 0 -> switch (Integer.compare(sum, maxSum)) {
                        case 1 -> true;
                        case 0 -> (st == -1) || (l < st);
                        default -> false;
                    };
                    default -> false;
                };

                if (upd) {
                    minLen = len;
                    maxSum = sum;
                    st = l;
                }
                sum -= arr.get(l);
                l++;
            }
        }

        if (st == -1) {
            System.out.println("No summ");
        } else {
            int endIndex = st + minLen - 1;
            String output = String.format("Length = %d%nSum = %d%nStart = %d%nFinish = %d",
                    minLen, maxSum, st, endIndex);
            System.out.println(output);
        }
    }
}
