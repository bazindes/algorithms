package com.baz.app.google.medium;

public class MinimumSubSetSum {

    /**
     * 给出一个数组，要求两这个数组分为两个部分，分别对两个部分求和，使两个和的绝对差值最小，输出这个最小差值
     *     eg, [1,2,3,4,5]，可以将它分为[1, 2, 4]和[3, 5]两个部分，对应的和分别为7， 8输出1
     * @param nums
     * @return
     */

    public int minCombineSum(int[] nums){
        return helper(0, 0, 0, nums);
    }
    private int helper(int leftSum, int rightSum, int start, int[] nums){
        if(start == nums.length){
//            System.out.println(leftSum + " " + rightSum);
            return Math.abs(leftSum - rightSum);
        }
        return Math.min(
                helper(leftSum + nums[start], rightSum, start + 1, nums) ,
                helper(leftSum, rightSum + nums[start], start + 1, nums)
        );
    }

    public void test(){
        int[] nums = {1,2,3,4,5};
        System.out.println(minCombineSum(nums));
    }

}
