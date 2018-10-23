package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class RangeSumQuery_Immutable implements Facebook {

    /**
     * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
     *
     * Example:
     * Given nums = [-2, 0, 3, -5, 2, -1]
     *
     * sumRange(0, 2) -> 1
     * sumRange(2, 5) -> -1
     * sumRange(0, 5) -> -3
     * Note:
     * You may assume that the array does not change.
     * There are many calls to sumRange function.
     */

    int [] dp;
    public RangeSumQuery_Immutable(int[] nums) {
        if(nums == null || nums.length == 0) return;
        dp = new int[nums.length + 1];
        for(int i=0; i<nums.length; i++){
            dp[i + 1] = (nums[i] + dp[i]);
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
