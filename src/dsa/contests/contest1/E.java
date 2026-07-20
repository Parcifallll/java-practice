package dsa.contests.contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// дано кубическое уравнение с ровно одним корнем. причем коэфф любые (но a!=0), значит нужно рассмотреть когда a>0 и а<0 (развернуть бин поиск)
// найти корень с точностью не менее 4 знаков после запятой
public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        double eps = Math.pow(10, -5); // ну либо пробегаемся циклом (обычно 100-200 итераций, чтобы делить отрезок пополам с каждой итерацией)

        double lo = -100_000;
        double hi = 100_000;
        double x = 0;
        while (lo <= hi + eps) {
            x = lo + (hi - lo) / 2;
            double value = a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
            if (value * a > 0) {
                hi = x - eps;
            } else lo = x + eps;

        }
        System.out.printf("%.4f", x);
    }
}
