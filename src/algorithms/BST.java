package algorithms;

import java.util.ArrayList;

public class BST {
    private Node root;
    private ArrayList<Node> arr = new ArrayList<>();

    private static class Node {
        int val;
        Node right, left;

        public Node(int val) {
            this.val = val;
        }
    }


    public void insert(int val) {
        Node node = new Node(val);
        if (root == null) {
            root = node;
            return;
        }
        insertRec(root, node);
    }

    public void insertRec(Node root, Node node) {
        if (node.val < root.val) {
            if (root.left == null) root.left = node;
            else insertRec(root.left, node);
        } else if (node.val > root.val) {
            if (root.right == null) root.right = node;
            else insertRec(root.right, node);
        }
    }

    public int findMin() {
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.val;
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {
        if (root == null) return;
        inorderRec(root.left);
        arr.add(root);
        inorderRec(root.right);
    }

    public void preorder() {
        preorderRec(root);
    }

    public void preorderRec(Node root) {
        if (root == null) return;
        arr.add(root);
        preorderRec(root.left);
        preorderRec(root.right);
    }

    public void postorder() {
        postorderRec(root);
    }

    public void postorderRec(Node root) {
        if (root == null) return;
        postorderRec(root.left);
        postorderRec(root.right);
        arr.add(root);
    }
}