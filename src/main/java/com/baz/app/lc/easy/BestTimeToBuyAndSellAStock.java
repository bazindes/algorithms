package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

public class BestTimeToBuyAndSellAStock implements Facebook {

    public int maxProfit(int[] prices) {
        int lo = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[lo])
                profit = Math.max(profit, prices[i] - prices[lo]);
            else {
                lo = i;
            }
        }

        return profit;
    }


    public void test(){
        int[] p = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(p));
        p = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(p));
    }

}
