package com.baz.app.lc.easy;
import com.baz.app.util.*;
/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-30
*/
class MinimumDepthofBinaryTree{

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int l = (root.left == null) ? Integer.MAX_VALUE : minDepth(root.left);
        int r = (root.right == null) ? Integer.MAX_VALUE : minDepth(root.right);
        return Math.min(l, r) + 1;
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
        System.out.println(minDepth(t0));
    }
}