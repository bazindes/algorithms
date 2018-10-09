package com.baz.app.facebook.hard;

public class MaximumSumOf3NonOverlappingSubsarray {

    /**
     * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
     *
     * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
     *
     * Return the result as a list of indices representing the starting position of each interval (0-indexed).
     * If there are multiple answers, return the lexicographically smallest one.
     *
     * Example:
     * Input: [1,2,1,2,6,7,5,1], 2
     * Output: [0, 3, 5]
     * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
     * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
     * Note:
     * nums.length will be between 1 and 20000.
     * nums[i] will be between 1 and 65535.
     * k will be between 1 and floor(nums.length / 3).
     */

    // dp[i][j] stands for in ith sum, the max non-overlap sum we can have from 0 to j
    // id[i][j] stands for in ith sum, the first starting index for that sum

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][]dp = new int[4][nums.length + 1];
        int sum = 0;
        int[] acc = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            acc[i] = sum;
        }

        int[][] id = new int[4][nums.length + 1];
        for(int i = 1; i < 4; i ++){
            for (int j = k - 1; j < nums.length; j ++){
                int temp = j - k < 0 ? acc[j] : acc[j] - acc[j - k] + dp[i - 1][j - k];

                if(j - k >= 0){
                    dp[i][j] = dp[i][j - 1];
                    id[i][j] = id[i][j - 1];
                }
                if(j > 0 && temp> dp[i][j - 1]) {
                    dp[i][j] = temp;
                    id[i][j] = j - k + 1;
                }

            }
        }

        int[] res = new int[3];
        res[2] = id[3][nums.length - 1];
        res[1] = id[2][res[2] - 1];
        res[0] = id[1][res[1] - 1];

        return res;
    }


}
