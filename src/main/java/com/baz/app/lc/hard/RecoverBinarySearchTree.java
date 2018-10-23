package com.baz.app.lc.hard;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

public class RecoverBinarySearchTree implements Facebook {

    public void recoverTree(TreeNode root) {
        helper(root);
        int cur = fir.val;
        fir.val = sec.val;
        sec.val = cur;
    }

    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode fir = null;
    TreeNode sec = null;
    private void helper(TreeNode node){
        if(node == null) return;
        helper(node.left);
        if( fir == null && prev.val >= node.val)
            fir = prev;
        if( fir != null && prev.val >= node.val)
            sec = node;
        prev = node;
        helper(node.right);
    }


    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(3);
        TreeNode l1r2 = new TreeNode(2);
        root.left = l1;
        l1.right = l1r2;
        Utils.inOrderPrintTree(root);
        System.out.println();
        recoverTree(root);
        Utils.inOrderPrintTree(root);
    }

}
