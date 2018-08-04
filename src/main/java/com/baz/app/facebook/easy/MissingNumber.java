package com.baz.app.facebook.easy;

public class MissingNumber {

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

    public void test(){
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
        nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

}
