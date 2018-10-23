package com.baz.app.lc.easy;

import com.baz.app.Interface.google.Google;
import com.baz.app.util.Utils;

import java.util.Arrays;

public class NearestStoreAndHouses implements Google {

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

    public int[] solution(int[] stores, int[] houses) {
        // write your code in Java SE 8
        // corner case, not specified in question, assume to return null
        if(stores == null || stores.length == 0 || houses == null || houses.length == 0) return null;

        // my thought is go through houses to find nearest stores
        // ans indicates results
        int[] ans = new int[houses.length];
        // corner case
        if(stores.length == 1){
            if(houses.length == 1) return stores;
            Arrays.fill(ans, stores[0]);
            return ans;
        }
        // 1. sort the store, in order to use binary search
        Arrays.sort(stores);
        // 2. go through all houses, try to find nearest one using binary search
        for(int i = 0; i < houses.length; i ++){
            int index = bsHelper(stores, houses[i]);
            // if(index == 0){
            //     ans[i] = Math.abs(houses[i] - stores[index]) < Math.abs(houses[i] - stores[index + 1]) ? stores[index] : stores[index + 1];
            // }else{
            //     ans[i] = Math.abs(houses[i] - stores[index]) < Math.abs(houses[i] - stores[index - 1]) ? stores[index] : stores[index - 1];
            // }
            if(index == stores.length - 1){
                ans[i] = Math.abs(houses[i] - stores[index]) < Math.abs(houses[i] - stores[index - 1]) ? stores[index] : stores[index - 1];
            }else{
                ans[i] = Math.abs(houses[i] - stores[index]) < Math.abs(houses[i] - stores[index + 1]) ? stores[index] : stores[index + 1];
            }
        }

        // time complexity: O(mlogn) n is length of stores, m is length of houses
        // space complexity: O(m) for ans array
        return ans;

    }

    private int bsHelper(int[] stores, int loc){
        // corner case, -1 means not found
        if(stores == null || stores.length == 0) return -1;
        int lo = 0;
        int hi = stores.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(stores[mid] == loc){
                return mid;
            }
            if(stores[mid] > loc){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }

}
