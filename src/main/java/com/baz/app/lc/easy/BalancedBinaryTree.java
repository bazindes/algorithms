package com.baz.app.lc.easy;
import com.baz.app.util.*;

/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-29
*/
class BalancedBinaryTree{
    boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        maxDepth(root);
        return isBalance;
    }

    private int maxDepth(TreeNode node){
        if(node == null) return 0;
        int l = maxDepth(node.left);
        int r = maxDepth(node.right);
        if(Math.abs(l-r) > 1) isBalance = false;
        return 1 + Math.max(l, r);
    }

    public void test(){
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        t0.left = t1;
        t0.right = t2;
        t2.left = t3;
        t2.right = t4;

        Utils.preOrderPrintTree(t0);
        System.out.println(isBalanced(t0));

        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n5;
        n3.right = n6;

        Utils.preOrderPrintTree(n0);
        System.out.println(isBalanced(n0));
    }

}