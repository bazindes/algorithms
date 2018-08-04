package com.baz.app.facebook.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.Stack;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root);
    }

    // recursive O(n) O(1)
    private int helper(TreeNode node){
        if(node == null || (node.left == null && node.right == null)) return 0;
        int l = 0;
        int r = 0;
        if(node.left != null)
            l = (node.left.left == null && node.left.right == null) ? node.left.val : helper(node.left);
        if(node.right != null)
            r = helper(node.right);
        return l + r;
    }

    //easy to understand
    private int helper2(TreeNode node){
        if(node == null) return 0;
        int ans = 0;

        if(node.left != null){
            if(node.left.left == null || node.left.right == null) ans += node.left.val;
            else ans += helper2(node.left);
        }
        if(node.right != null)
            ans += helper2(node.right);

        return ans;
    }

    //iterative
    private int helperIterative(TreeNode node){
        if(node == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left != null){
                if(cur.left.left == null && cur.left.right == null)
                    ans += cur.left.val;
                else
                    stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }

        return ans;
    }


    public void test(){
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        TreeNode r1l2 = new TreeNode(15);
        TreeNode r1r2 = new TreeNode(7);
        root.left = l1;
        root.right = r1;
        r1.left = r1l2;
        r1.right = r1r2;

        Utils.inOrderPrintTree(root);
        System.out.println();
        System.out.println(sumOfLeftLeaves(root));
        System.out.println(helper2(root));
        System.out.println(helperIterative(root));

    }
}
