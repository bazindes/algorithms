package com.baz.app.facebook.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        if(node.val > p.val && node.val > q.val){
            return helper(node.left, p, q);
        }else if(node.val < p.val && node.val < q.val){
            return helper(node.right, p, q);
        }else {
            return node;
        }
    }

    public void test(){
        TreeNode root = new TreeNode(6);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(8);
        TreeNode l1l2 = new TreeNode(0);
        TreeNode l1r2 = new TreeNode(4);
        TreeNode r1l2 = new TreeNode(7);
        TreeNode r1r2 = new TreeNode(9);
        TreeNode l1r2l3 = new TreeNode(3);
        TreeNode l1r2r3 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.left = r1l2;
        r1.right = r1r2;
        l1r2.left = l1r2l3;
        l1r2.right = l1r2r3;

        Utils.inOrderPrintTree(root);
        System.out.println();
        System.out.println(lowestCommonAncestor(root, l1, r1).val);
        System.out.println(lowestCommonAncestor(root, l1r2, l1).val);
        System.out.println(lowestCommonAncestor(root, l1r2l3, r1l2).val);
    }

}
