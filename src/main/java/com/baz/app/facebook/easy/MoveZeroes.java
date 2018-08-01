package com.baz.app.facebook.easy;

import com.baz.app.util.Utils;

import javax.rmi.CORBA.Util;

public class MoveZeroes {

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
