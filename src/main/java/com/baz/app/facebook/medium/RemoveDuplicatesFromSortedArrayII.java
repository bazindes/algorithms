package com.baz.app.facebook.medium;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j : nums){
            if( i < 2 || j > nums[i - 2])
                nums[i ++] = j;
        }
        return i;
    }

    public void test(){
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }

}
