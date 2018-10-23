package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeNode;

public class InorderSuccessorInBST implements Facebook {

    /**
     * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
     * Note: If the given node has no in-order successor in the tree, return null.
     *
     * Example 1:
     *
     * Input: root = [2,1,3], p = 1
     *   2
     *  / \
     * 1   3
     * Output: 2
     * Example 2:
     *
     * Input: root = [5,3,6,2,4,null,null,1], p = 6
     *       5
     *      / \
     *     3   6
     *    / \
     *   2   4
     *  /
     * 1
     * Output: null
     */

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inOrderTrav(root, p);
    }

    // O(logn) O(logn)
    private TreeNode inOrderTrav(TreeNode node, TreeNode p){
        if (node == null)
            return null;

        if (node.val <= p.val) {
            return inOrderTrav(node.right, p);
        } else {
            TreeNode left = inOrderTrav(node.left, p);
            return (left != null) ? left : node;
        }
    }

    // O(logn) O(logn)
    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }
}
