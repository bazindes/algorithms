package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal implements Facebook {

    /**
     * Given a binary tree, return the zigzag level order traversal of its nodes' values.
     * (ie, from left to right, then right to left for the next level and alternate between).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its zigzag level order traversal as:
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     */

    //O(n) O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            while (size -- > 0){
                TreeNode cur = queue.poll();
                if(level % 2 != 0)
                    temp.add(0, cur.val);
                else
                    temp.add(cur.val);
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
            ans.add(temp);
            level ++;
        }

        return ans;
    }

    //recursive O(n) O(n)
    public List<List<Integer>> zigzagLevelOrderRecur(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, ans, 0);
        return ans;
    }

    private void helper(TreeNode node, List<List<Integer>> ans, int level){
        if(node == null) return;
        if(ans.size() < level){
            List<Integer> temp = new LinkedList<>();
            ans.add(temp);
        }
        List<Integer> cur = ans.get(level);
        if(level % 2 == 0)
            cur.add(node.val);
        else
            cur.add(0, node.val);
        helper(node.left, ans, level + 1);
        helper(node.right, ans, level + 1);
    }

    public void test(){

    }

}
