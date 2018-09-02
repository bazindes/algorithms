package com.baz.app.facebook.medium;

import com.baz.app.util.TreeNode;

public class FlattenBinaryTreetoLinkedList {

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

    public void test(){

    }

}
