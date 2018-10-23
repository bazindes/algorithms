package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

public class CombinationSumIV implements Facebook {

    //Recursive solution TLE
    public int combinationSum4(int[] nums, int target) {
        return helper(nums, target);
    }

    private int helper(int[]nums, int target){
        if(target == 0) return 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(target >= nums[i])
                ans += helper(nums, target - nums[i]);
        }
        return ans;
    }

    //Iterative DP
    public int combinationSumDP(int[] nums, int target){
        int[] cos = new int[target + 1];
        cos[0] = 1;

        for (int i = 1; i < cos.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i >= nums[j]){
                    cos[i] += cos[i - nums[j]];
                }
            }
        }

        return cos[target];
    }

    public void test(){
        int[]nums = {1, 2, 3};
        System.out.println(combinationSumDP(nums, 4));
    }

}
