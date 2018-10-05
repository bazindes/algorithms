package com.baz.app.google.easy;

import com.baz.app.util.Utils;

import java.util.Arrays;

public class NearestStoreAndHouses {

    /**
     * 2. 给两个array，一个代表房子位置一个代表商店位置，输出一个array，内容是每个房子最邻近的商店的位置，
     * 因为代码不要求performance所以我就O(n^2) 写了两个loop，一个在主method里面，loop每一个房子的位置，另一个写在helper里面，
     * loop每一个商店的位置并计算出商店位置-房子位置的绝对值，然后找最小绝对值的商店位置以后返回给主method写到return的array里面就完成啦。
     */

    public int[] findStores(int[] houses, int[] stores){
        int[] ans = new int[houses.length];

        Arrays.sort(stores);

        for (int i = 0; i < houses.length; i ++){
            int index = finder(stores, houses[i]);
            if(index == 0)
                ans[i] = stores[index];
            else
                ans[i] = Math.abs(houses[i] - stores[index]) < Math.abs(houses[i] - stores[index - 1]) ? stores[index] : stores[index - 1];
        }

        return ans;
    }

    private int finder(int[] stores, int tar){
        if(stores == null || stores.length == 0) return -1;
        int lo = 0;
        int hi = stores.length - 1;

        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(stores[mid] == tar)
                return mid;
            else if(stores[mid] < tar)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }

    public void test(){
        int[] s = {2,3,5,8,20,12};
        int[] h = {1,3,10,13};
        Utils.printArray(findStores(h, s));
    }

}
