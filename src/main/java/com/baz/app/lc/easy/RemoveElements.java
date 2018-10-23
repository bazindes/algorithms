package com.baz.app.lc.easy;
import com.baz.app.util.*;
/**
* <h1>Leetcode 27</h1>
*
* @author  baz
* @version 1.0
* @since   06-18-2018
*/
class RemoveElements{

    public int removeElements(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                nums[j] = nums[i];
                j ++;
            }
        }
        return j;
    }

    public void test() {
        int []arr = {3, 2, 2, 3};
        Utils.printArray(arr);     
        removeElements(arr, 2);
        Utils.printArray(arr);   
    }
}