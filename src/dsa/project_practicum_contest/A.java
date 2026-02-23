package dsa.project_practicum_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n - сегодняшнее число, m - две недели назад. Найти тот же день недели в предыдущей недели
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n <= 7){
            System.out.println(m + 7);
        }
        else System.out.println(n - 7);
    }


}