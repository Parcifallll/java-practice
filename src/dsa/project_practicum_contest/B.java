package dsa.project_practicum_contest;

import java.io.IOException;
import java.util.Scanner;

// посчитать кол-во троек abc
public class B {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int a = 0, ab = 0, abc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') a++;
            if (s.charAt(i) == 'b') ab += a;
            if (s.charAt(i) == 'c') abc += ab;
        }

        System.out.println(abc);
    }


}
