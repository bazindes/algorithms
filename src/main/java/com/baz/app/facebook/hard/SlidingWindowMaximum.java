package com.baz.app.facebook.hard;

import com.baz.app.util.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
     * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
     *
     * Example:
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     *
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
     *
     * Follow up:
     * Could you solve it in linear time?
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        // corner case
        if(nums == null || nums.length == 0) return new int[0];
        if(k == 1) return nums;

        int[] ans = new int[nums.length - k + 1];

        int curMax = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int i = 0; i < k; i++) {
            map.put(i, nums[i]);
            curMax = Math.max(curMax, nums[i]);
        }

        int i = k - 1;
        while (i < nums.length){

        }

        return ans;
    }

    public void test(){
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        Utils.printArray(maxSlidingWindow(nums , 3));
    }

}
