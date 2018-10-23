package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.Stack;

public class LongestUnivaluePath implements Google {

    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int max = Integer.MIN_VALUE;
        max = Math.max(max, dfsHelper(root));
        max = Math.max(max, longestUnivaluePath(root.left));
        max = Math.max(max, longestUnivaluePath(root.right));
        return max;
    }

    public int dfsHelper(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        int ans = 0;
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left != null && cur.val == cur.left.val){
                stack.push(cur.left);
                ans ++;
            }
            if(cur.right != null && cur.val == cur.right.val){
                stack.push(cur.right);
                ans ++;
            }
        }
        return ans;
    }

    int len = 0;
    public int longestUnivaluePathRecursive(TreeNode root) {
        if(root == null) return len;
        recusive(root);
        return len;
    }

    private int recusive(TreeNode node){
        if(node == null) return 0;
        int l = recusive(node.left);
        int r = recusive(node.right);

        int ansL = 0;
        int ansR = 0;
        if(node.left != null && node.val == node.left.val){
            ansL += l + 1;
        }
        if(node.right != null && node.val == node.right.val){
            ansR += r + 1;
        }
        len = Math.max(len, ansL + ansR);

        return Math.max(ansL, ansR);
    }

    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(5);
        TreeNode l1l2 = new TreeNode(4);
        TreeNode l1r2 = new TreeNode(4);
        TreeNode r1r2 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.right = r1r2;

        Utils.inOrderPrintTree(root);
        System.out.println();
        System.out.println(longestUnivaluePathRecursive(root));

        TreeNode _root = new TreeNode(5);
        TreeNode _l1 = new TreeNode(4);
        TreeNode _r1 = new TreeNode(5);
        TreeNode _l1l2 = new TreeNode(1);
        TreeNode _l1r2 = new TreeNode(1);
        TreeNode _r1r2 = new TreeNode(5);
        _root.left = _l1;
        _root.right = _r1;
        _l1.left = _l1l2;
        _l1.right = _l1r2;
        _r1.right = _r1r2;

        Utils.inOrderPrintTree(_root);
        System.out.println();
        System.out.println(longestUnivaluePathRecursive(_root));
    }

}
