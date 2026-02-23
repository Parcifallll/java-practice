package algorithms;

import java.util.*;

public class PruferCodeProcessor {
    private final List<Integer> prufer;
    private final int vertexCount;
    private List<List<Integer>> adjList; //adjacency list contains lists of connected vertexes


    public PruferCodeProcessor(List<Integer> prufer) {
        this.prufer = new ArrayList<>(prufer);
        this.vertexCount = prufer.size() + 2; //|V| = P(T).length() + 2
    }

    public List<List<Integer>> toAdjList() {
        if (adjList != null) return adjList;
        adjList = new ArrayList<>(vertexCount + 1); //create a list with vertexes (n+1 means the start from 1 to n)
        for (int i = 0; i <= vertexCount; i++) {
            adjList.add(new LinkedList<>()); //create an empty list for each vertex (1 to n)
        }

        int[] degree = new int[vertexCount + 1]; //create an array with degrees - 1 by default
        Arrays.fill(degree, 1);
        for (int vertex : prufer) { //for each vertex in prufer code increase its degree in array
            degree[vertex]++;
        }

        for (int v : prufer) { //for each vertex in prufer code
            for (int vertex = 1; vertex <= vertexCount; vertex++) { //find minimal leaf
                if (degree[vertex] == 1) {
                    adjList.get(v).add(vertex); //for each v in prufer we created a list -> add leaf (vertex) to these lists
                    adjList.get(vertex).add(v); //already added leaf to v's list -> must add v to this list (bind)
                    degree[v]--; //vertexex are binded -> decrease degrees
                    degree[vertex]--;
                    break; //already process the leaf
                }
            }
        }

        int u = -1, v = -1; //last two leaves are residual (not proceeded yet)
        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            if (degree[vertex] == 1) {
                if (u == -1) u = vertex; //find first residual leaf
                else {
                    v = vertex; //find second residual leaf
                    break;
                }
            }
        }
        adjList.get(u).add(v);
        adjList.get(v).add(u);
        return adjList;
    }

    public String getFormattedAdjList() { //for all vertexes in the tree
        if (adjList == null) toAdjList(); //the adj list is not built yet
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < adjList.size(); i++) { //traverse the list of each vertex: List <List<Integer>>
            sb.append(i).append(": ");
            List<Integer> neighbours = adjList.get(i);
            for (int j = 0; j < neighbours.size(); j++) { //traverse the list of neighbours for each vertex in the adj list
                sb.append(neighbours.get(j));
                if (j < neighbours.size() - 1) sb.append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> prufer = new ArrayList<>();
        System.out.println("Enter Prufer's code (sample: '1 2 3 4 5'): ");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        for (String number : numbers) {
            prufer.add(Integer.parseInt(number));
        }
        PruferCodeProcessor processor = new PruferCodeProcessor(prufer);
        System.out.println(processor.getFormattedAdjList());
    }
}

