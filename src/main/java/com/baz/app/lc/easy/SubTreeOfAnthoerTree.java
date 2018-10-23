package com.baz.app.lc.easy;

import com.baz.app.Interface.google.Google;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

public class SubTreeOfAnthoerTree implements Google {

    //O(m*n) O(n)
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    private boolean traverse(TreeNode s, TreeNode t){
        return s!=null && (helper(s,t) || traverse(s.left, t) || traverse(s.right, t));
    }
    private boolean helper(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && helper(s.left , t.left) && helper(s.right, t.right);
    }

    //isSub
    public boolean isSubtree2(TreeNode s, TreeNode t){
        if(s == null) return false;
        if(helper2(s, t)) return true;
        return isSubtree2(s.left, t) || isSubtree2(s.right, t);
    }

    public boolean helper2(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return helper2(s.left, t.left) && helper2(s.right, t.right);
    }

    public void test(){
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(5);
        TreeNode l1l2 = new TreeNode(1);
        TreeNode l1r2 = new TreeNode(2);
        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        Utils.inOrderPrintTree(root);
        System.out.println();
        Utils.inOrderPrintTree(l1);
        System.out.println();
        System.out.println(isSubtree(root, l1));
        System.out.println(isSubtree2(root, l1));
        System.out.println(isSubtree(l1, root));
        System.out.println(isSubtree2(l1, root));

    }

}
