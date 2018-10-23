package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

public class ConstructBSTFromGivenPreorderTraversal implements Facebook {

    /**
     * Given preorder traversal of a binary search tree, construct the BST.
     *
     * For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.
     *      10
     *    /   \
     *   5     40
     *  /  \      \
     * 1    7      50
     */

    class Index{
        int index = 0;
    }

    public TreeNode construct(int[] nums){
        Index index = new Index();
//        return helper(nums, 0, nums.length - 1, index, nums.length);
        return helperImprove(nums, index, nums[0], Integer.MIN_VALUE, Integer.MAX_VALUE, nums.length);
    }

    private TreeNode helper(int[] nums, int lo, int hi, Index prev, int size){
        // exit condition
        if(prev.index >= size || lo > hi) return null;

        // pick root
        TreeNode root = new TreeNode(nums[prev.index]);
        prev.index = prev.index + 1;

        if(lo == hi) return root;

        //search for first element greater than root
        int i = lo;
        for (; i <= hi; i++) {
            if(nums[i] > root.val)
                break;
        }

        root.left = helper(nums, prev.index, i - 1, prev, size);
        root.right = helper(nums, i, hi, prev, size);

        return root;
    }

    private TreeNode helperImprove(int[] nums, Index prev, int key, int min, int max, int size){
        // base case
        if(prev.index >= size) return null;

        TreeNode root = null;

        if(key > min && key < max){
            root = new TreeNode(key);
            prev.index ++;
            if(prev.index < size){
                root.left = helperImprove(nums, prev, nums[prev.index], min, key, size);
                root.right = helperImprove(nums, prev, nums[prev.index], key, max, size);
            }

        }

        return root;
    }

    public void test(){
        int[] nums = {10, 5, 1, 7, 40, 50};
        TreeNode root = construct(nums);
        Utils.inOrderPrintTree(root);
    }

}
