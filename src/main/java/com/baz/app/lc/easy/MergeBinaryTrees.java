package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

public class MergeBinaryTrees implements Facebook {

    /**
     * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
     *
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
     * Otherwise, the NOT null node will be used as the node of new tree.
     *
     * Example 1:
     * Input:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * Output:
     * Merged tree:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     *
     *
     * Note: The merging process must start from the root nodes of both trees.
     */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null) return t1 == null ? t2 : t1;
        TreeNode temp = new TreeNode(t1.val + t2.val);
        TreeNode l = mergeTrees(t1.left, t2.left);
        TreeNode r = mergeTrees(t1.right, t2.right);
        temp.left = l;
        temp.right = r;
        return temp;
    }

    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t1l2 = new TreeNode(3);
        TreeNode t1r2 = new TreeNode(2);
        TreeNode t1l2l3 = new TreeNode(5);
        t1.left = t1l2;
        t1.right = t1r2;
        t1l2.left = t1l2l3;

        Utils.inOrderPrintTree(t1);
        System.out.println();
        TreeNode t2 = new TreeNode(2);
        TreeNode t2l2 = new TreeNode(1);
        TreeNode t2r2 = new TreeNode(3);
        TreeNode t2l2r3 = new TreeNode(4);
        TreeNode t2r2r3 = new TreeNode(7);
        t2.left = t2l2;
        t2.right = t2r2;
        t2l2.right = t2l2r3;
        t2r2.right = t2r2r3;
        Utils.inOrderPrintTree(t2);
        System.out.println();
        Utils.inOrderPrintTree(mergeTrees(t1, t2));

    }

}
