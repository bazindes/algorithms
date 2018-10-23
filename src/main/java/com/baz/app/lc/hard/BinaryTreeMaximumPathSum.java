package com.baz.app.lc.hard;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaximumPathSum implements Facebook {

    /**
     * Given a non-empty binary tree, find the maximum path sum.
     * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
     * The path must contain at least one node and does not need to go through the root.
     * Example 1:
     * Input: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * Output: 6
     * Example 2:
     * Input: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * Output: 42
     */

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int ans = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size -- > 0){
                TreeNode cur = queue.poll();
                int sum = helper(cur.left, 0) + helper(cur.right, 0) + cur.val;
                ans = Math.max(sum, ans);
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return ans;
    }

    private int helper(TreeNode node, int curVal){
        if(node == null) return 0;
        return node.val + Math.max(helper(node.left, curVal), helper(node.right, curVal));
    }

    public void test(){
        TreeNode root = new TreeNode(-10);
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
        System.out.println(maxPathSum(root));
    }

}
