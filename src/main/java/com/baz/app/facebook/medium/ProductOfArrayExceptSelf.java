package com.baz.app.facebook.medium;

import com.baz.app.util.Utils;

public class ProductOfArrayExceptSelf {

    /**
     * Brute Force
     * */
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int pro = 1;
            for (int j = 0; j < nums.length; j++) {
                if( i != j){
                    pro *= nums[j];
                }
            }
            ans[i] = pro;
            pro = 1;
        }
        return ans;
    }

    /**
     *DP solution
     * */
    public int[] dpSolution(int[] nums){
        int pro = 1;
        for (int i = 0; i < nums.length; i++) {
            pro *= nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = pro/nums[i];
        }
        return ans;
    }

    public void test(){
        int[] nums = {1,2,3,4};
        Utils.printArray(productExceptSelf(nums));
        Utils.printArray(dpSolution(nums));
    }

}
