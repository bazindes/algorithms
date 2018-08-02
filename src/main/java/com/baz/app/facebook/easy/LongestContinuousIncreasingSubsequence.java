package com.baz.app.facebook.easy;

public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int [] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int max = Integer.MIN_VALUE;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] > nums[j-1]){
                max = Math.max(max, j - i + 1);
            }else {
                max = Math.max(max, 1);
                i = j;
            }
        }
        return max;
    }

    public void test(){
        int[] nums = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
        nums = new int[]{2,2,2,2,2};
        System.out.println(findLengthOfLCIS(nums));
    }

}
