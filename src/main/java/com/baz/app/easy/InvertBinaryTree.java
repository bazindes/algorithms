package com.baz.app.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

public class InvertBinaryTree {

    public void invert(TreeNode node){
        if(node == null) return;
        if(node.left!=null) invert(node.left);
        if(node.right!=null) invert(node.right);
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
    }

    public void test(){
        TreeNode root = new TreeNode(0);
        TreeNode r0 = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(5);
        TreeNode r5 = new TreeNode(6);
        TreeNode r6 = new TreeNode(7);
        TreeNode r7 = new TreeNode(8);
        root.left = r0;
        root.right = r1;
        r0.left = r2;
        r0.right =r3;
        r1.left = r4;
        r1.right = r5;
        r2.left = r6;
        r2.right = r7;

        Utils.inOrderPrintTree(root);
        invert(root);
        System.out.println();
        Utils.inOrderPrintTree(root);
    }
}


