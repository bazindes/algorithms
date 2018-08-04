package com.baz.app.facebook.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k);
    }

    //O(n) O(n)
    private boolean helper(TreeNode node, int k){
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(set.contains(cur.val)) return true;
            set.add(k - cur.val);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        return false;
    }

    public void test(){
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(6);
        TreeNode l1l2 = new TreeNode(2);
        TreeNode l1r2 = new TreeNode(4);
        TreeNode r1r2 = new TreeNode(7);
        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.right = r1r2;

        Utils.inOrderPrintTree(root);
        System.out.println();
        System.out.println(findTarget(root, 9));
        System.out.println(findTarget(root, 28));
    }

}
