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
        System.out.println(myTree.root);
        System.out.println("-------print in level--------");
        myTree.traverseInLevel();
        System.out.println("\n-------print in order--------");
        myTree.traverseInOrder();

        myTree=new BinaryTree();
        myTree.root=new TreeNode(1);
        myTree.root.left=new TreeNode(2);
        myTree.root.right=new TreeNode(3);
        myTree.root.left.left=new TreeNode(4);
        myTree.root.left.left.left=new TreeNode(5);
        myTree.root.left.left.right=new TreeNode(6);
        myTree.root.left.left.right.left=new TreeNode(7);
        myTree.root.left.left.right.right=new TreeNode(8);
        myTree.root.left.left.right.right.left=new TreeNode(9);
        myTree.root.right=new TreeNode(3);
        myTree.root.right.left=new TreeNode(10);
        myTree.root.right.right=new TreeNode(12);
        myTree.root.right.left=new TreeNode(10);
        myTree.root.right.left.left=new TreeNode(11);
        myTree.root.right.left.left.right=new TreeNode(13);
        System.out.println("\n-------print complex binary tree in order--------");
        myTree.traverseInOrder();
    }

}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(){};
    TreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
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

class BinaryTree{
    TreeNode root;



    public void add(int data){
        root=insertTree(root,data);
    }
    private TreeNode insertTree(TreeNode root, int data){
        if(root==null){
            root=new TreeNode(data);
            /*since root consists address of this.root now because of
             root= new TreeNode(data); this.root and root in function is not same,
             so now we have to return function root to this.root
             */
            return root;
        }
        if (root.data>data) {
            root.left=insertTree(root.left,data);
        }else if (root.data<data){
            root.right=insertTree(root.right,data);
        }
        return root;
    }

    public void traverseInLevel(){
        Queue<TreeNode> levelQ = new LinkedList<>();
        if(root!=null) levelQ.add(root);
        while(levelQ.size()!=0){
            if(levelQ.peek().left!=null) levelQ.add(levelQ.peek().left);
            if(levelQ.peek().right!=null) levelQ.add(levelQ.peek().right);
            System.out.print(levelQ.peek().data+"   ");
            levelQ.poll();
        }
    }

    public void traverseInOrder(){
        inOrder(root);
    }

    private void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+"   ");
        inOrder(root.right);
    }
}