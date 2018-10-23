package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

public class FirstMissingPositive implements Facebook {

    /**
     * Given an unsorted integer array, find the smallest missing positive integer.
     * Example 1:
     * Input: [1,2,0]
     * Output: 3
     * Example 2:
     * Input: [3,4,-1,1]
     * Output: 2
     * Example 3:
     * Input: [7,8,9,11,12]
     * Output: 1
     * Note:
     * Your algorithm should run in O(n) time and uses constant extra space.
     */

    public int firstMissingPositive(int[] nums) {
        int ans = 1;
        int len = nums.length;
        int i = 0;

        while (i < len) {
            if(nums[i] >= 0 && nums[i] < len && nums[nums[i]] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }else {
                i ++;
            }
        }

        while (ans < len && nums[ans] == ans){
            ans ++;
        }

        if(len == 0 || ans < len)
            return ans;
        else
            return nums[0] == ans ? ans + 1 : ans;
    }


    public void test(){
        int[]nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }

}
