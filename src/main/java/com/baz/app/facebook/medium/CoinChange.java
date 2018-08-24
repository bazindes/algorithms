package com.baz.app.facebook.medium;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Arrays;

public class CoinChange {

    /**
     * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     *
     * Example 1:
     *
     * Input: coins = [1, 2, 5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     * Example 2:
     *
     * Input: coins = [2], amount = 3
     * Output: -1
     * Note:
     * You may assume that you have an infinite number of each kind of coin.
     */

    public int coinChange(int[] coins, int amount) {
        int ans = 0;
        ans = helper(coins, amount, new int[amount]);
        return ans;
    }

    //top down helper O(S*n) S:amount n:denominations O(S)
    private int helper(int[]coins, int amount, int[]count){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(count[amount - 1] != 0) return count[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int temp = helper(coins, amount - coins[i], count);
            if(temp >= 0 && temp < min)
                min = 1 + temp;
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }

    //Bottom up helper O(S*n) O(S)
    public int coinChangeBU(int[] coins, int amount){
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i] , dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public void test(){
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
        System.out.println(coinChangeBU(coins, 11));
    }

}
