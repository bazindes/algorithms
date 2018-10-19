package com.baz.app.facebook.easy;

import com.baz.app.util.Utils;

import javax.rmi.CORBA.Util;

public class MoveZeroes {

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Example:
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     *
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */

    public void moveZeroes(int [] nums){
        if(nums == null || nums.length < 2) return;
        int i = 0;
        int j = 0;
        while ( i < nums.length && j < nums.length){
            if(nums[i] == 0 && nums[j] != 0){
                if(i < j){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                j++;
            }else{
                if(nums[i] != 0){
                    i++;
                }
                if(nums[j] == 0){
                    j ++;
                }
            }
        }
    }

    public void test(){
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(nums);
        Utils.printArray(nums);
    }

}
