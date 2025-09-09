package Algorithms;

import java.util.*;


public class Huffman {
    static class Node implements Comparable<Node> {
        char c;
        int val;
        Node r;
        Node l;

        Node(char c, int val) { //for leaves (letters)
            this.c = c;
            this.val = val;
        }

        Node(Node l, Node r) { //for not-leaves (e.x. 'brcd')
            this.c = '0'; //not a letter (sentinel)
            this.val = r.val + l.val;
            this.l = l;
            this.r = r;

        }

        @Override
        public int compareTo(Node n) {
            return this.val - n.val; //comparator
        }

    }

    private static TreeMap<Character, Integer> buildMap(String string) { //frequency map
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : string.toCharArray()) {
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else {
                map.put(c, 1);
            }
        }
        return map;
    }

    private static Node buildTree(TreeMap<Character, Integer> map) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) { //add all Nodes to pq
            char key = entry.getKey();
            int val = entry.getValue();
            Node leaf = new Node(key, val);
            pq.add(leaf);
        }

        while (pq.size() > 1) { //build resulting pq
            Node l = pq.poll(); //pop min Nodes
            Node r = pq.poll();
            Node newNode = new Node(l, r);
            pq.add(newNode);
        }
        return pq.poll(); //root
    }

    private static void buildCodes(String code, Map<Character, String> map, Node node) {
        if (node == null) return;
        if (node.l == null && node.r == null) {
            if (!code.isEmpty()) map.put(node.c, code);
            else map.put(node.c, "0"); //last symbol is encoded by "0" code
            return;
        }
        buildCodes(code + "0", map, node.l); //to left nodes move
        buildCodes(code + "1", map, node.r); //to right nodes move
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        TreeMap<Character, Integer> treeMap = buildMap(string);
        Node root = buildTree(treeMap);

        Map<Character, String> codeMap = new HashMap<>();
        buildCodes("", codeMap, root);

        String code = "";
        for (char c : string.toCharArray()) {
            code += codeMap.get(c);
        }

        System.out.printf("%d %d%n", treeMap.size(), code.length());
        codeMap.forEach((ch, cde) -> System.out.printf("%c: %s%n", ch, cde));
        System.out.println(code);
    }

}
