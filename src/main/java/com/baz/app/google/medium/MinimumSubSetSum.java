package com.baz.app.google.medium;

public class MinimumSubSetSum {


    public int minCombineSum(int[] nums){
        return helper(0, 0, 0, nums);
    }
    private int helper(int leftSum, int rightSum, int start, int[] nums){
        if(start == nums.length){
            System.out.println(leftSum + " " + rightSum);
            return Math.abs(leftSum - rightSum);
        }
        return Math.min(
                helper(leftSum + nums[start], rightSum, start + 1, nums) ,
                helper(leftSum, rightSum + nums[start], start + 1, nums)
        );
    }

    public void test(){
        int[] nums = {1,2,3,4,5,3};
        System.out.println(minCombineSum(nums));
    }

}
