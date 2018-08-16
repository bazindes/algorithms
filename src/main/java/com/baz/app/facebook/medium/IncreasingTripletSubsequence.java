package com.baz.app.facebook.medium;

public class IncreasingTripletSubsequence {

    /**
     * The main idea is keep two values when check all elements in the array:
     * the minimum value min until now and the second minimum value secondMin from the minimum value's position until now.
     * Then if we can find the third one that larger than those two values at the same time,
     * it must exists the triplet subsequence and return true.
     *
     * What need to be careful is:
     * we need to include the condition that some value has the same value with minimum number,
     * otherwise this condition will cause the secondMin change its value.
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= small){
                small = nums[i];
            }else if(nums[i] <= big){
                big = nums[i];
            }else {
                return true;
            }
        }

        return false;
    }

    public void test(){
        int[] nums = {1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
        nums = new int[]{5,4,3,2,1};
        System.out.println(increasingTriplet(nums));
    }

}
