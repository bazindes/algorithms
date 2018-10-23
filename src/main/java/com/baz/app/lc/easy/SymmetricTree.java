package com.baz.app.lc.easy;
import com.baz.app.util.*;
/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-22
*/
class SymmetricTree{
    public boolean isSymmetric(TreeNode root){
        if(root == null) return false;
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        if(root.left.val != root.right.val) return false;
        invert(root.left);
        return check(root.left, root.right);
    }
    private void invert(TreeNode node){
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.right = left;
        node.left = right;
        if(left != null){
            invert(node.right);
        }
        if(right != null){
            invert(node.left);
        }
    }
    private boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return check(p.left, q.left) && check(p.right, q.right);
        return false;
    }

    public void test(){
        TreeNode t10 = new TreeNode(1);
        TreeNode t20 = new TreeNode(2);
        TreeNode t21 = new TreeNode(2);
        t10.left = t20;
        t10.right = t21;
        TreeNode t30 = new TreeNode(3);
        t20.right = t30;
        TreeNode t32 = new TreeNode(3);
        t21.left = t32;
        Utils.inOrderPrintTree(t10);
        System.out.println();
        System.out.println(isSymmetric(t10));
        Utils.inOrderPrintTree(t10);
        
        // TreeNode c10 = new TreeNode(1);
        // TreeNode c20 = new TreeNode(2);
        // TreeNode c21 = new TreeNode(2);
        // c10.left = c20;
        // c10.right = c21;
        // TreeNode c31 = new TreeNode(3);
        // c20.right = c31;
        // TreeNode c33 = new TreeNode(3);
        // c21.right = c33;
        // System.out.println(isSymmetric(c10));
    }

}