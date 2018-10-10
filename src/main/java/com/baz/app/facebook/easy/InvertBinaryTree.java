package com.baz.app.facebook.easy;

import com.baz.app.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    /**
     * Invert a binary tree.
     *
     * Example:
     * Input:
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * Output:
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * Trivia:
     * This problem was inspired by this original tweet by Max Howell:
     *
     * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
     */

    // O(n) O(n)
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.right = l;
        root.left = r;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    // O(n) O(n)
    public TreeNode invertTreeIter(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

}
