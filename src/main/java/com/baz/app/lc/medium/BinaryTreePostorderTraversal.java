package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal implements Facebook {

    /**
     * Given a binary tree, return the postorder traversal of its nodes' values.
     *
     * Example:
     *
     * Input: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * Output: [3,2,1]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        helper(ans, root);
        return ans;
    }

    private void helper(List<Integer> ans, TreeNode node){
        if(node == null) return;
        helper(ans, node.left);
        helper(ans, node.right);
        ans.add(node.val);
    }

    public List<Integer> postorderTraversalIter(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();

            ans.add(0, cur.val);
            if(cur.left != null)
                stack.push(cur.left);
            if(cur.right != null)
                stack.push(cur.right);

        }

        return ans;
    }

}
