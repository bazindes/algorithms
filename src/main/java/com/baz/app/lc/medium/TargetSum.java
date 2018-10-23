package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

public class TargetSum implements Facebook {
    /**
     * DP solution O(ln)
     * */
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, S);
    }

    public int helper(int[] nums, int tar){
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if(dp[i - 1][j + 1000] > 0){
                    dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000];
                    dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000];
                }
            }
        }

        return tar > 1000 ? 0 : dp[nums.length - 1][tar + 1000];
    }

    /**
     *Brute Force O(2^n)
     */
    int num = 0;
    private int bruteForce(int[] nums, int S){
        helper(nums, 0, S, 0);
        return num;
    }

    private void helper(int[] nums, int n, int tar, int sum){
        if(n == nums.length){
            if(sum == tar){
                num ++;
            }
        }else {
            helper(nums, n + 1, tar, sum + nums[n]);
            helper(nums, n + 1, tar, sum - nums[n]);
        }
    }

    public void test(){
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums , 3));
        System.out.println(bruteForce(nums , 3));
    }

}
