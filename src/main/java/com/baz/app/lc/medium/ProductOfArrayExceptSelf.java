package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.Utils;

public class ProductOfArrayExceptSelf implements Facebook {

    /**
     * Given an array nums of n integers where n > 1,
     * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     *
     * Example:
     *
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Note: Please solve it without division and in O(n).
     *
     * Follow up:
     * Could you solve it with constant space complexity?
     * (The output array does not count as extra space for the purpose of space complexity analysis.)
     */

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

    //Iterative solution O(n) O(1)
    public int[] productExceptSelfIter(int[] nums) {
        int pro = 1;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                pro *= nums[i];
            else
                n ++;
        }
        int[] ans = new int[nums.length];
        if(n > 1){
            return ans;
        }else if(n == 1){
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 0)
                    ans[i] = pro;
            }
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                ans[i] = pro/nums[i];
            else
                ans[i] = pro;
        }
        return ans;
    }

    //O(n) O(1)
    public int[] productExceptSelf2(int[] nums) {

        int len = nums.length;
        int [] output = new int[len];

        int leftMult = 1, rightMult = 1;

        for(int i = len-1; i >= 0; i--){
            output[i] = rightMult;
            rightMult *= nums[i];
        }
        for(int j = 0; j < len; j++){
            output[j] *= leftMult;
            leftMult *= nums[j];

        }

        return output;

    }

    public void test(){
        int[] nums = {1,2,3,4};
        Utils.printArray(productExceptSelf(nums));
        Utils.printArray(productExceptSelfIter(nums));
    }

}
