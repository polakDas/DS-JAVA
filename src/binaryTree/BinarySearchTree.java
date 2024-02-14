package binaryTree;

public class BinarySearchTree {
    public Node root;

    public static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
        }
    }

    // insert using loop - O(log(n))
    public void insert(int data) {
        Node node = new Node(data);

        if (root == null) {
            root = node;
            return;
        }

        Node temp = root;
        Node prev = null;

        while (temp != null) {
            prev = temp;

            if (node.data > temp.data) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

        if (node.data > prev.data) {
            prev.right = node;
        } else {
            prev.left = node;
        }
    }

    public boolean search(int data, Node root) {
        while (root != null) {
            if (root.data == data) return true;

            if (data > root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return false;
    }

    public void insertR(int data) {
        root = insert(root, data);
    }

    // insert using recursion
    private Node insert(Node root, int data) {
        if (root == null) return new Node(data);

        if (data < root.data) root.left = insert(root.left, data);
        else if (data > root.data) root.right = insert(root.right, data);

        return root;
    }

    public boolean searchR(Node node, int data) {
        if (node == null) return false;
        if (node.data == data) return true;

        if (data > node.data) return searchR(node.right, data);
        else return searchR(node.left, data);
    }
}
