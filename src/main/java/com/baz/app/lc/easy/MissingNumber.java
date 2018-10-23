package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

public class MissingNumber implements Facebook {

    //O(n) O(n)
    public int missingNumber(int[] nums) {
        int[] ans = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ans[nums[i]] = 1;
        }

        for (int i = 0; i < ans.length; i++) {
            if(ans[i] == 0) return i;
        }

        return -1;
    }

    //O(n) O(1)
    //Gauss' Formula
    public int missingNumberGF(int [] nums){
        int expect = nums.length * (nums.length + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return expect - sum;
    }

    /**
     * O(n) O(1)
     * Bit manipulation
     * */
    public int missingNumberBM(int[] nums){
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans ^= i ^ nums[i];
        }
        return ans;
    }

    public void test(){
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumberGF(nums));
        System.out.println(missingNumberBM(nums));
        nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumberGF(nums));
        System.out.println(missingNumberBM(nums));
    }

}
