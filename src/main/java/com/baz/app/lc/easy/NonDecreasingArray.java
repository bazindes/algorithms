package com.baz.app.lc.easy;

import com.baz.app.Interface.google.Google;

import java.util.Arrays;

public class NonDecreasingArray implements Google {

    public boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length < 3) return true;
        int index = -1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]){
                if(index < 0) index = i;
                else return false;
            }
        }
        if(index == nums.length - 1 || index - 1 == 0) return true;
        int i = 0;
        boolean l = true;
        while (i<index-1){
            if(nums[i++] > nums[index]) l =false;
        }
        int j = nums.length -1;
        boolean r = true;
        while (j > index){
            if(nums[j--] < nums[index - 1]) r = false;
        }
        return r || l;
    }

    public void test(){
        int[] nums = {4, 2, 3};
        System.out.println(checkPossibility(nums));
        nums = new int[]{4, 2, 1};
        System.out.println(checkPossibility(nums));
        nums = new int[]{1, 5, 4, 6, 7, 10, 8, 9};
        System.out.println(checkPossibility(nums));
    }

}
