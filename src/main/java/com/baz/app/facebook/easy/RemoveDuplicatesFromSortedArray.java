package com.baz.app.facebook.easy;

import com.baz.app.util.Utils;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] == nums[j]){

            }else {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public void test(){
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
        Utils.printArray(nums);
        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        Utils.printArray(nums);
    }

}
