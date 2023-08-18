package com.dsAlgo2023.tree;

public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(50);
        treeNode.left = new TreeNode(30);
        treeNode.right = new TreeNode(70);
        treeNode.left.left = new TreeNode(20);
        treeNode.left.right = new TreeNode(40);
        treeNode.right.left = new TreeNode(60);
        treeNode.right.right = new TreeNode(80);
        System.out.println("--treeNode---->" + treeNode);
        treeNode = deleteNode(30, treeNode);
        System.out.println("--deleteNode-->" + treeNode);

    }

    public static TreeNode deleteNode(int key, TreeNode root) {
        if (root == null) return null;
        else if (key < root.data) root.left = deleteNode(key, root.left);

        else if (key > root.data) root.right = deleteNode(key, root.right);

        else {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode inOrderSuccesor = findInOrderSuccesor(root.left);
                root.data = inOrderSuccesor.data;
                root.left = deleteNode(root.data, root.left);
                return root;
            }
        }
        return root;
    }

    private static TreeNode findInOrderSuccesor(TreeNode root) {
        if (root.right == null) return root;
        return findInOrderSuccesor(root.right);
    }
}