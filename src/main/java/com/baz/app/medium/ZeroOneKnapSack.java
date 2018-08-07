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


    public void test(){
        int[] prices = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        System.out.println(knapSackFill(weights, prices, W, 3));
    }

}
