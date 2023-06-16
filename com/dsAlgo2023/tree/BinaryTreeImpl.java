package com.dsAlgo2023.tree;

public class BinaryTreeImpl {
    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        myTree.add(10);
        myTree.add(8);
        myTree.add(12);
        myTree.add(7);
        myTree.add(9);
        System.out.println(myTree.root);
    }

}

class BinaryTree{
    TreeNode root;


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
}