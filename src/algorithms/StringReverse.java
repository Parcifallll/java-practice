package algorithms;

import java.util.*;

public class StringReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.nextLine().toCharArray();
        for (int i = str.length - 1; i >= 0; i--) {
            System.out.print(str[i]);
        }
        scanner.close();
        System.out.print("\n");
    }
}