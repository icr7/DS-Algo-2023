package com.dsAlgo2023.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImpl {
    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        myTree.add(10);
        myTree.add(8);
        myTree.add(12);
        myTree.add(7);
        myTree.add(9);
        System.out.println("tree size: " + myTree.size());
        System.out.println("-------print in level--bfs------");
        myTree.printInLevelBfs();
        System.out.println("\n-------print in level--dfs------");
        myTree.printInLevelDfs();
        System.out.println("\n-------print reverse in level--dfs------");
        myTree.printReverseInLevelDfs();
        System.out.println("\n-------print in order--------");
        myTree.traverseInOrder();
        System.out.println("\nmaximum value in myTree: " + myTree.maxInTree());
        System.out.println("maximum depth of myTree: " + myTree.maxDepth());

        myTree = new BinaryTree();
        myTree.root = new TreeNode(1);
        myTree.root.left = new TreeNode(2);
        myTree.root.right = new TreeNode(3);
        myTree.root.left.left = new TreeNode(4);
        myTree.root.left.left.left = new TreeNode(5);
        myTree.root.left.left.right = new TreeNode(6);
        myTree.root.left.left.right.left = new TreeNode(7);
        myTree.root.left.left.right.right = new TreeNode(8);
        myTree.root.left.left.right.right.left = new TreeNode(9);
        myTree.root.right = new TreeNode(3);
        myTree.root.right.left = new TreeNode(10);
        myTree.root.right.right = new TreeNode(12);
        myTree.root.right.left = new TreeNode(10);
        myTree.root.right.left.left = new TreeNode(11);
        myTree.root.right.left.left.right = new TreeNode(13);
        System.out.println("\ncomplex tree size: " + myTree.size());
        System.out.println("-------print complex binary tree in level bfs--------");
        myTree.printInLevelBfs();
        System.out.println("\n-------print complex binary tree in level dfs--------");
        myTree.printInLevelDfs();
        System.out.println("\n-------print complex reverse binary tree in level dfs--------");
        myTree.printReverseInLevelDfs();
        System.out.println("\n-------print complex binary tree in order--------");
        myTree.traverseInOrder();
        System.out.println("\n-------print complex binary tree pre order--------");
        myTree.traversePreOrder();
        System.out.println("\n-------print complex binary tree post order--------");
        myTree.traversePostOrder();
        System.out.println("\nmaximum value in complex myTree: " + myTree.maxInTree());
        System.out.println("maximum depth of complex myTree: " + myTree.maxDepth());

    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class BinaryTree {
    TreeNode root;


    public void add(int data) {
        root = insertTree(root, data);
    }

    private TreeNode insertTree(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            /*since root consists address of this.root now because of
             root= new TreeNode(data); this.root and root in function is not same,
             so now we have to return function root to this.root
             */
            return root;
        }
        if (root.data > data) {
            root.left = insertTree(root.left, data);
        } else if (root.data < data) {
            root.right = insertTree(root.right, data);
        }
        return root;
    }

    public void printInLevelBfs() {
        Queue<TreeNode> levelQ = new LinkedList<>();
        if (root != null) levelQ.add(root);
        while (levelQ.size() != 0) {
            if (levelQ.peek().left != null) levelQ.add(levelQ.peek().left);
            if (levelQ.peek().right != null) levelQ.add(levelQ.peek().right);
            System.out.print(levelQ.peek().data + "   ");
            levelQ.poll();
        }
    }

    public void traverseInOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + "   ");
        inOrder(root.right);
    }

    public void traversePreOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "   ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void traversePostOrder() {
        postOrder(root);
    }


    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "   ");
    }

    public int size() {
        return size(root);
    }

    private int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + 1 + size(root.right);
    }

    public int maxInTree() {
        return maxInTree(root);
    }

    private int maxInTree(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(Math.max(maxInTree(root.left), root.data), maxInTree(root.right));
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public void printInLevelDfs() {
        int height = maxDepth();
        for (int i = 0; i < height; i++)
            printInLevelDfs(root, i);
    }

    public void printReverseInLevelDfs() {
        int height = maxDepth();
        for (int i = height-1; i >=0; i--)
            printInLevelDfs(root, i);
    }

    private void printInLevelDfs(TreeNode root, int level) {
        if (root == null) return;
        else if (level == 0) System.out.print(root.data + "   ");
        else {
            printInLevelDfs(root.left, level - 1);
            printInLevelDfs(root.right, level - 1);
        }
    }
}