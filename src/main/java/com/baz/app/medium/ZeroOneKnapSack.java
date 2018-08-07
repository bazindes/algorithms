package com.baz.app.medium;

import java.util.Map;

public class ZeroOneKnapSack {


    public int knapSackFill(int[]weights, int[]prices, int totalWeight, int n){
        if(n == 0 || totalWeight == 0) return 0;
        if(weights[n-1] > totalWeight)
            return knapSackFill(weights,prices, totalWeight,n-1);
        else
            return Math.max(
                    prices[n-1] + knapSackFill(weights,prices,totalWeight-weights[n-1],n-1) ,
                    knapSackFill(weights, prices,   totalWeight, n-1)
            );

    }

    public int knapSackIterative(int[]weights, int[]prices, int totalWeight, int n){

        int[][] ans = new int[n + 1][totalWeight + 1];

        int i, j;
        for( i = 0; i <= n; i ++){
            for( j = 0; j <= totalWeight; j ++){
                if( i == 0 || j == 0){
                    ans[i][j] = 0;
                }else if(weights[i - 1] <= j){
                    ans[i][j] = Math.max(prices[i - 1] + ans[i - 1][j - weights[i-1]] , ans[i - 1][j]);
                }else {
                    ans[i][j] = ans[i-1][j];
                }
            }
        }

        return ans[n][totalWeight];
    }


    public void test(){
        int[] prices = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        System.out.println(knapSackFill(weights, prices, W, 3));
        System.out.println(knapSackIterative(weights, prices, W, 3));
    }

}
