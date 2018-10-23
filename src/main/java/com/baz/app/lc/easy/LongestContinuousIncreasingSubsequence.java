package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

public class LongestContinuousIncreasingSubsequence implements Facebook {

    /**
     *
     Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

     Example 1:
     Input: [1,3,5,4,7]
     Output: 3
     Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
     Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
     Example 2:
     Input: [2,2,2,2,2]
     Output: 1
     Explanation: The longest continuous increasing subsequence is [2], its length is 1.
     Note: Length of the array will not exceed 10,000.

     */

    // O(n) O(1)
    public int findLengthOfLCIS(int [] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int max = Integer.MIN_VALUE;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] > nums[j-1]){
                max = Math.max(max, j - i + 1);
            }else {
                max = Math.max(max, 1);
                i = j;
            }
        }
        return max;
    }

    public void test(){
        int[] nums = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
        nums = new int[]{2,2,2,2,2};
        System.out.println(findLengthOfLCIS(nums));
    }

}
