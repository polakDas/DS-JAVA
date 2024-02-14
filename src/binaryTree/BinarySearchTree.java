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

        while(temp != null) {
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
}
