package com.baz.app.facebook.medium;

public class BestTimeToBuyAndSellStockWithTransectionFee {

    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = - prices[0];
        for (int i = 0; i < prices.length; i++) {
            cash = Math.max(cash, prices[i] + hold - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }


    public void test(){
        int[] p = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(p , 2));
    }
}
