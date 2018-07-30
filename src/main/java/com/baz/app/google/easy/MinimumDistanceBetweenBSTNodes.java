package com.baz.app.google.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

public class MinimumDistanceBetweenBSTNodes {

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int minDiffInBST(TreeNode root){
        if(root == null) return min;
        minDiffInBST(root.left);
        if(prev != null){
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        minDiffInBST(root.right);
        return min;
    }

    public void test(){

        TreeNode root = new TreeNode(5);
        TreeNode r1 = new TreeNode(7);
        TreeNode l1 = new TreeNode(4);
        root.right = r1;
        root.left = l1;
        TreeNode r2 = new TreeNode(8);
        TreeNode l2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        l1.left = l2;
        l2.right = l3;
        l3.left = r3;
        r1.right = r2;

        Utils.inOrderPrintTree(root);
        System.out.println();
        System.out.println(minDiffInBST(root));
    }

}
