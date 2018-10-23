package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.TreeNode;

public class FlattenBinaryTreetoLinkedList implements Facebook {

    /**
     * Given a binary tree, flatten it to a linked list in-place.
     *
     * For example, given the following tree:
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * The flattened tree should look like:
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     */

    //O(n) O(n)
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode temp = root;
        while (temp.right != null){
            temp = temp.right;
        }
        temp.right = right;
    }

    //O(n) O(n)
    private TreeNode prev = null;
    public void flatten2(TreeNode root){
        if(root == null) return;
        flatten2(root.left);
        flatten2(root.right);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void test(){

    }

}
