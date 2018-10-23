package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.TreeNode;
import org.omg.CORBA.PUBLIC_MEMBER;

public class ClosetBinarySearchTreeValue implements Facebook {

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

    // O(n) O(1/n)
    public int closestValue(TreeNode root, double target) {
        int closet = root.val;
        if(root.val > target && root.left != null)
            closet = closestValue(root.left, target);
        else if(root.right != null)
            closet = closestValue(root.right, target);
        return Math.abs(target - root.val) <= Math.abs(target - closet) ? root.val : closet;
    }

    // O(n) O(1)
    public int closestValueIter(TreeNode root, double target){
        int val = root.val;
        TreeNode cur = val > target ? root.left : root.right;

        while (cur != null){
            int temp = cur.val;
            val = Math.abs(val - target) < Math.abs(temp - target) ? val : temp;
            cur = temp > target ? cur.left : cur.right;
            if(cur == null) return val;
        }

        return val;
    }

}
