package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray implements Google {

    /**
     * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
     *
     * You need to find the shortest such subarray and output its length.
     *
     * Example 1:
     * Input: [2, 6, 4, 8, 10, 9, 15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     * Note:
     * Then length of the input array is in range [1, 10,000].
     * The input array may contain duplicates, so ascending order here means <=.
     */

    //O(nlogn) O(n)
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int[] sorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (sorted[i] == nums[i]) i++;
            if (sorted[j] == nums[j]) j--;
            if (sorted[i] != nums[i] && sorted[j] != nums[j]) break;
        }
        return i == j ? 0 : j - i + 1;
    }

    //O(n) O(1)
    public int bestSolution(int[] nums){
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1])
                flag = true;
            if(flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if(nums[i] < nums[i + 1])
                flag = true;
            if(flag)
                max = Math.max(max, nums[i]);
        }

        int l, r;
        for (l = 0; l < nums.length; l++) {
            if(min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if(max > nums[r])
                break;
        }

        return r - 1 < 0 ? 0 : r - 1 + l;
    }

    public void test(){
        int[] n = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(n));
        System.out.println(bestSolution(n));
    }

}
