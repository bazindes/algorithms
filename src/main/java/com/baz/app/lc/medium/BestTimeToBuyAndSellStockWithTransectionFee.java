package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class BestTimeToBuyAndSellStockWithTransectionFee implements Facebook {

    /**
     *    DP Solution
     */
    public int maxProfit(int[] prices, int fee) {
        // cash: 手头的现金，即总的赚的金额，同时也是未持股时的现金额
        int cash = 0;
        // hold: 手中有持股时的现金，即总金额减去手中股票的买入价
        int hold = - prices[0];
        for (int i = 0; i < prices.length; i++) {
            // 如果卖出持股比未持股赚，则卖出
            cash = Math.max(cash, prices[i] + hold - fee);
            // hold 其实代表买入的最低价
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }


    public void test(){
        int[] p = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(p , 2));
    }
}
