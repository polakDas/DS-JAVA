package binaryTree;

public class BinaryTree {
    private int index = -1;
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     *
     * @param arr - it is required to build the tree
     * @return the root {@link Node}
     */
    public Node buildTree(int[] arr) {
        index++;

        if(arr[index] == -1) return null;

        Node root = new Node(arr[index]);
        root.left = buildTree(arr);
        root.right = buildTree(arr);

        return root;
    }

    public void preOrder(Node root) {
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}
