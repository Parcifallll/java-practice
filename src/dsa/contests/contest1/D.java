package dsa.contests.contest1;

import java.util.Locale;
import java.util.Scanner;

/** Найдите такое число х (double), чтобы Math.pow(x, 2) + Math.sqrt(x + 1) = C, с точностью 6 знаков после запятой. 1<=C<=10^10
 *
 * Заметим, что f(x)>=0, значит воспользуемся бинарным поиском по ответу. Причем, верхняя граница hi - это максимально возможный x.
 * х находится так: слева у нас x^2 + [sqrt()>=0], а справа C=10^10 => max(x) = 10^5
 *
 *
 * */
public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double c = Double.parseDouble(sc.nextLine());
        double lo = 0, hi = Math.pow(10, 5);
        double x = 0;
        double eps = Math.pow(10, -6);
        while (lo <= hi + eps) { // + accuracy with 6 digits after a decimal point
            x = lo + (hi - lo) / 2;
            double value = Math.pow(x, 2) + Math.sqrt(x + 1);

            if (value > c) {
                hi = x - eps;
            } else
                lo = x + eps;
        }
        Locale.setDefault(Locale.ENGLISH); // decimal point instead of decimal comma
        System.out.printf("%.6f", x);
    }
}
