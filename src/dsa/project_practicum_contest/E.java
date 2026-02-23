package dsa.project_practicum_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Дан отрезок длины n, а также k пар вида (i, j) - подотрезки. Задача - выяснить, можно ли узнать сумму чисел на всем отрезке, и сколько хватит для этого пар (i, j).
public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph.get(l - 1).add(r);
            graph.get(r).add(l - 1);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u : graph.get(v)) {
                if (dist[u] == -1) {
                    dist[u] = dist[v] + 1;
                    queue.add(u);
                }
            }
        }

        if (dist[n] == -1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            System.out.println(dist[n]);
        }
    }
}