import binaryTree.BinarySearchTree;
import binaryTree.BinaryTree;
import linkedList.LinkedList;
import queue.Queue;
import stack.Stack;

public class Main {
    public static void main(String[] args) {
        // Linked list
//        LinkedList<String> linkedList = new LinkedList<>();
//
//        linkedList.add("Kazipara");
//
//        System.out.println(linkedList.removeFirst());
//
//        linkedList.add("Shewrapara");
//
//        System.out.println(linkedList.removeLast());
//
//        linkedList.addFirst("Taltola");
//
//        System.out.println(linkedList);


        // Stack using linked list
//        Stack<Integer> stack = new Stack<>();
//
//        stack.pushLL(10);
//        stack.pushLL(20);
//        stack.pushLL(30);
//        stack.pushLL(34);
//
//        System.out.println(stack.sizeLL());
//
//        System.out.println(stack.peekLL());
//        System.out.println(stack.popLL());
//
//        System.out.println(stack);


        // Queue using linked list
//        Queue<Integer> queue = new Queue<>();
//
//        queue.enqueue(90);
//        queue.enqueue(190);
//        queue.enqueue(290);
//
//        System.out.println(queue);
//        System.out.println(queue.dequeue());
//
//        System.out.println("Peek: " + queue.peek());
//
//        queue.enqueue(390);
//        queue.enqueue(590);
//
//        System.out.println(queue.dequeue());
//
//        System.out.println("Size: " + queue.size());
//        System.out.println(queue);


        // Binary Tree
//        BinaryTree binaryTree = new BinaryTree();
//
//        BinaryTree.Node root = binaryTree.buildTree(new int[]{1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1});
//
//        binaryTree.preOrder(root);
//        System.out.println();
//        binaryTree.inOrder(root);
//        System.out.println();
//        binaryTree.postOrder(root);

        // Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertR(5);
        bst.insertR(3);
        bst.insertR(7);
        bst.insertR(1);
        bst.insertR(4);
        bst.insertR(6);
        bst.insertR(8);

        BinarySearchTree.Node root = bst.root;

        System.out.println(bst.searchR(root, 10));   // false
        System.out.println(bst.searchR(root, 6));    // true
    }
}