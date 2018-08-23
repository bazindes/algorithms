package com.baz.app.facebook.medium;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.
     *
     * Example:
     *
     * Input: [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     * Note:
     *
     * There may be more than one LIS combination, it is only necessary for you to return the length.
     * Your algorithm should run in O(n2) complexity.
     * Follow up: Could you improve it to O(n log n) time complexity?
     */

    //BruteForce O(2^n) O(n^2)
    public int lengthOfLISBF(int[] nums){
        return helper(nums, Integer.MIN_VALUE, 0);
    }

    private int helper(int[] nums, int prev, int curPos){
        if(curPos == nums.length) return 0;
        int taken = 0;
        if(nums[curPos] > prev)
            taken = 1 + helper(nums, nums[curPos], curPos + 1);
        int notTaken = helper(nums, nums[curPos], curPos + 1);
        return Math.max(taken , notTaken);
    }

    //DP O(n^2) O(n)
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[i]){
                    maxVal = Math.max(dp[j] , maxVal);
                }
            }
            dp[i] = maxVal + 1;
            ans = Math.max(dp[i] , ans);
        }
        return ans;
    }


    //DP O(nlogn) O(n)
    public int lengthOFLISDPBS(int[] nums){
        if(nums == null || nums.length == 0) return 0;

        int[]dp = new int[nums.length];
        int len = 0;
        for (int i : nums){
            int j = Arrays.binarySearch(dp, 0, len, i);
            if(j < 0){
                j = -( j + 1 );
            }
            dp[j] = i;
            if( j == len){
                len ++;
            }
        }
        return len;
    }

    public void test(){
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOFLISDPBS(nums));
    }
}
