package com.baz.app.facebook.medium;

import com.baz.app.util.Utils;

public class NextPermutation {

    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     * The replacement must be in-place and use only constant extra memory.
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     *
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */

    public void nextPermutation(int[] nums) {
        //corner case
        if(nums == null || nums.length == 0) return;

        //general code
        int j = nums.length - 1;
        for (; j > 0 ; j--) {
            if(nums[j] > nums[j - 1])
                break;
        }
        j --;
        int i = j;
        for (; i < nums.length; i++) {
            if(nums[i] < nums[j])
                break;
        }
        if(i == nums.length) i --;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        j ++;
        i = nums.length - 1;
        while (i != j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            j ++;
            i --;
        }
    }

    public void test(){
        int[]nums = {1, 2, 3};
        nextPermutation(nums);
        Utils.printArray(nums);
    }

}
