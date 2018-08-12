package com.baz.app.facebook.medium;

import com.baz.app.util.Utils;

public class SortColors {

    //radix sort
    public void sortColors(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i : nums){
            max = max > i ? max : i;
        }

        int[]counts = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]] ++;
        }
        int j = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0){
                nums[j ++] = i;
                counts[i] --;
            }
        }
    }

    //based on AC 012
    public void sortColorsAC(int[] nums){
        int i = 0;
        int j = 0;
        for (int k = 0; k < nums.length; k++) {
            int val = nums[k];
            nums[k] = 2;
            if(val < 2){
                nums[j] = 1;
                j ++;
            }
            if(val == 0){
                nums[i] = 0;
                i ++;
            }
        }
    }

    public void test(){
        int[] nums = {2, 0, 2, 1, 1, 0};
//        sortColors(nums);
        sortColorsAC(nums);
        Utils.printArray(nums);
    }

}
