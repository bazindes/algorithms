package com.baz.app.facebook.easy;

import com.baz.app.util.TreeNode;

public class ClosetBinarySearchTreeValue {

    /**
     * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
     * Note:
     *
     *     Given target value is a floating point.
     *     You are guaranteed to have only one unique value in the BST that is closest to the target.
     *
     * Example:
     * Input: root = [4,2,5,1,3], target = 3.714286
     *
     *     4
     *    / \
     *   2   5
     *  / \
     * 1   3
     *
     * Output: 4
     */

    public int closestValue(TreeNode root, double target) {
        int closet = root.val;
        if(root.val > target && root.left != null)
            closet = closestValue(root.left, target);
        else if(root.right != null)
            closet = closestValue(root.right, target);
        return Math.abs(target - root.val) <= Math.abs(target - closet) ? root.val : closet;
    }

}
