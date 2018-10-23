package com.baz.app.lc.medium;

import com.baz.app.Interface.Google.Google;

public class CardGameII implements Google {


    public int canWin(int[]costs, int[]damages, int totalCost, int n){
        if(n == 0 || totalCost == 0) return 0;
        if(costs[n-1] > totalCost)
            return canWin(costs,damages, totalCost,n-1);
        else
            return Math.max(
                    damages[n-1] + canWin(costs,damages,totalCost-costs[n-1],n-1) ,
                    canWin(costs, damages,   totalCost, n-1)
            );
    }

    public void test(){
        int[] damages = {1,2,3,4,5};
        int[] costs = {1,2,3,4,5};
        int totalCost = 10;
        System.out.println(canWin(costs, damages, totalCost, 5));
    }

}
