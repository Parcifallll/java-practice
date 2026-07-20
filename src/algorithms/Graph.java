package algorithms;

import java.util.*;

public class Graph {
    private int n;
    private List<Integer>[] adj;

    public Graph(int n) {
        this.n = n;
        this.adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void BFS(int v) {
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) { // проходим по каждой вершине ровно один раз
            v = queue.poll();
            System.out.println(v);

            for (int w : adj[v]) { // проходим только по соседям (поэтому не O(V*E), а O(V+E)
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(v);
        visited[v] = true;

        while (!stack.isEmpty()) {
            v = stack.pop();
            System.out.println(v);

            for (int i = adj[v].size() - 1; i >= 0; i--) {
                int nei = adj[v].get(i);
                if (!visited[nei]){
                    visited[nei] = true;
                    stack.push(nei);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 0);

        g.BFS(1);
    }
}


